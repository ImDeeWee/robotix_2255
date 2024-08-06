package org.example.Controller;

import org.example.JsonUtil;
import org.example.Model.Compte;
import org.example.Model.Email;
import org.example.Model.Fournisseur;
import org.example.Model.Utilisateur;
import org.example.View.EmailView;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur pour la gestion des courriels.
 */

public class EmailController {
    private EmailView view;
    private static final String CHEMIN_FICHIER_JSON = "Application\\src\\main\\java\\Donnees\\Comptes.json";
    private static final String CHEMIN_FICHIER_EMAILS = "Application\\src\\main\\java\\Donnees\\Email.json";

    /**
     * Constructeur de EmailController.
     * 
     * @param view la vue de gestion des courriels.
     */

    public EmailController(EmailView view) {
        this.view = view;
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            int choice = view.afficherMenuGestionCourriels();
            switch (choice) {
                case 1:
                    handleConfirmation();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Gère la confirmation d'inscription.
     */

    public void handleConfirmation() {
        String courriel = view.getDetail("Entrez votre courriel: ");
        String motDePasse = view.getDetail("Entrez votre mot de passe: ");

        List<Email> emails = JsonUtil.lireEmailsDepuisFichier(CHEMIN_FICHIER_EMAILS);
        if (emails == null) {
            System.out.println("Erreur de lecture des courriels.");
            return;
        }

        for (Email email : emails) {
            if (email.getCourriel().equals(courriel) && email.getMotDePasse().equals(motDePasse)) {
                email.setConfirmed(true);
                JsonUtil.ecrireEmailsDansFichier(emails, CHEMIN_FICHIER_EMAILS);

                List<Compte> comptes = JsonUtil.lireComptesDepuisFichier(CHEMIN_FICHIER_JSON);
                if (comptes == null) {
                    comptes = new ArrayList<>();
                }

                if ("Utilisateur".equals(email.getType())) {
                    Utilisateur utilisateur = new Utilisateur(email.getCourriel(), email.getPseudo(),
                            email.getMotDePasse(), email.getTelephone(), email.getNom(), email.getPrenom(),
                            email.getNomDeCompagnie(), email.getInterets());
                    comptes.add(utilisateur);
                } else if ("Fournisseur".equals(email.getType())) {
                    Fournisseur fournisseur = new Fournisseur(email.getCourriel(), email.getPseudo(),
                            email.getMotDePasse(), email.getTelephone(), email.getCapaciteFabrication());
                    comptes.add(fournisseur);
                }

                JsonUtil.ecrireComptesDansFichier(comptes, CHEMIN_FICHIER_JSON);
                System.out.println("Inscription confirmée.");
                return;
            }
        }

        System.out.println("Échec de la confirmation. Courriel ou mot de passe incorrect.");
    }

}
