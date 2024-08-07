package org.example.Controller;

import org.example.View.ConnexionMenuView;
import org.example.View.EmailView;
import org.example.Model.Compte;
import org.example.JsonUtil;
import org.example.Model.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contrôleur pour la gestion du menu de connexion et d'inscription.
 */

public class ConnexionMenuController {
    private ConnexionMenuView view;
    private EmailView emailView;
    private static final String CHEMIN_FICHIER_JSON = "Application\\src\\main\\java\\Donnees\\Comptes.json";
    private static final String CHEMIN_FICHIER_EMAILS = "Application\\src\\main\\java\\Donnees\\Email.json";

    /**
     * Constructeur de ConnexionMenuController.
     * 
     * @param view      la vue du menu de connexion.
     * @param emailView la vue de gestion des courriels.
     */

    public ConnexionMenuController(ConnexionMenuView view, EmailView emailView) {
        this.view = view;
        this.emailView = emailView;
    }

    /**
     * Exécute le menu de connexion et retourne le compte connecté.
     * 
     * @return le compte connecté, ou null si aucun compte n'est connecté.
     */

    public Compte run() {
        boolean exit = false;
        while (!exit) {
            int choice = view.AfficherConnexionMenu();
            switch (choice) {
                case 1:
                    Compte compte = handleConnexion();
                    if (compte != null) {
                        return compte;
                    }
                    break;
                case 2:
                    handleInscription();
                    break;
                case 3:
                    handleEmailGestion();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez entrer une des options [1 ou 2].");
            }
        }
        return null;
    }

    /**
     * Gère la connexion d'un utilisateur.
     * 
     * @return le compte connecté, ou null si la connexion échoue.
     */

    private Compte handleConnexion() {
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier(CHEMIN_FICHIER_JSON);
        if (comptes == null) {
            System.out.println("Le fichier JSON est introuvable.");
            return null;
        }

        while (true) {
            String[] details = view.getConnexionDetails();

            if (details == null) {
                return null;
            }

            String courriel = details[0];
            String motDePasse = details[1];

            for (Compte compte : comptes) {
                if (compte.getCourriel().equals(courriel) && compte.getMotDePasse().equals(motDePasse)) {
                    System.out.println("Connexion réussie.");
                    return compte;
                }
            }
            System.out.println("Échec de la connexion. Courriel ou mot de passe incorrect.");
            System.out.print("Voulez-vous réessayer? (1: oui, 2: retour au menu principal): ");
            String retry = view.getDetail("");
            if (!retry.equals("1")) {
                return null;
            }
        }
    }

    /**
     * Gère l'inscription d'un utilisateur ou d'un fournisseur.
     * 
     * @return null après l'inscription.
     */

    private Compte handleInscription() {
        boolean backToMain = false;
        while (!backToMain) {
            int choice = view.AfficherInscriptionMenu();
            switch (choice) {
                case 1:
                    handleUtilisateurInscription();
                    backToMain = true;
                    break;
                case 2:
                    handleFournisseurInscription();
                    backToMain = true;
                    break;
                case 3:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez entrer une des options [1-3].");
            }
        }
        return null;
    }

    /**
     * Gère l'inscription d'un utilisateur.
     */

    private void handleUtilisateurInscription() {
        String[] details = view.getInscriptionDetailsUtilisateur();
        String courriel = details[0];
        String pseudo = details[1];
        String motDePasse = details[2];
        String telephone = details[3];
        String nom = details[4];
        String prenom = details[5];
        String nomDeCompagnie = details[6];
        String[] interetsArray = details[7].split(",");
        ArrayList<String> interets = new ArrayList<>(Arrays.asList(interetsArray));

        if (isCourrielExistant(courriel)) {
            System.out.println("Le courriel est déjà utilisé. Veuillez utiliser un autre courriel.");
            return;
        }

        Email email = new Email("Utilisateur", courriel, pseudo, motDePasse, telephone, nom, prenom, nomDeCompagnie,
                interets, false, 0);

        List<Email> emails = JsonUtil.lireEmailsDepuisFichier(CHEMIN_FICHIER_EMAILS);
        if (emails == null) {
            emails = new ArrayList<>();
        }
        emails.add(email);
        JsonUtil.ecrireEmailsDansFichier(emails, CHEMIN_FICHIER_EMAILS);

        System.out.println(
                "Inscription réussie en tant qu'utilisateur. Veuillez confirmer votre inscription par courriel.");
        handleEmailGestion();
    }

    /**
     * Gère l'inscription d'un fournisseur.
     */

    private void handleFournisseurInscription() {
        String[] details = view.getInscriptionDetailsFournisseur();
        String courriel = details[0];
        String pseudo = details[1];
        String motDePasse = details[2];
        String telephone = details[3];
        int capaciteFabrication = Integer.parseInt(details[4]);

        if (isCourrielExistant(courriel)) {
            System.out.println("Le courriel est déjà utilisé. Veuillez utiliser un autre courriel.");
            return;
        }

        Email email = new Email("Fournisseur", courriel, pseudo, motDePasse, telephone, "", "", "", new ArrayList<>(),
                false, capaciteFabrication);

        List<Email> emails = JsonUtil.lireEmailsDepuisFichier(CHEMIN_FICHIER_EMAILS);
        if (emails == null) {
            emails = new ArrayList<>();
        }
        emails.add(email);
        JsonUtil.ecrireEmailsDansFichier(emails, CHEMIN_FICHIER_EMAILS);

        System.out.println(
                "Inscription réussie en tant que fournisseur. Veuillez confirmer votre inscription par courriel.");
        handleEmailGestion();
    }

    /**
     * Gère la gestion des courriels.
     */

    private void handleEmailGestion() {
        EmailController emailController = new EmailController(emailView);
        emailController.run();
    }

    /**
     * Vérifie si le courriel existe déjà dans les comptes.
     * 
     * @param courriel le courriel à vérifier.
     * @return true si le courriel existe déjà, false sinon.
     */

    private boolean isCourrielExistant(String courriel) {
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier(CHEMIN_FICHIER_JSON);
        if (comptes == null) {
            return false;
        }
        for (Compte compte : comptes) {
            if (compte.getCourriel().equals(courriel)) {
                return true;
            }
        }
        return false;
    }
}
