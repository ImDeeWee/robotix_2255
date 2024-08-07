package org.example.View;

import org.example.Model.Activite;
import org.example.Model.Composante;
import org.example.Model.Fournisseur;
import org.example.Model.Robot;
import org.example.Model.Utilisateur;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de vue pour le menu principal.
 */

public class MenuPrincipalView {
    private Scanner scanner;

    /**
     * Constructeur de MenuPrincipalView.
     */

    public MenuPrincipalView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu principal pour les utilisateurs.
     *
     * @return Le choix de l'utilisateur.
     */
    public int afficherMenuPrincipalUtilisateur() {
        System.out.println("");
        System.out.println("Menu principal");
        System.out.println("1. Modifier son profil");
        System.out.println("2. Gestion robots");
        System.out.println("3. Gestion composantes");
        System.out.println("4. Trouver un fournisseur");
        System.out.println("5. Gestion d'activités");
        System.out.println("6. Gestion des abonnements");
        System.out.println("7. Voir notifications");
        System.out.println("8. Quitter Robotix");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu principal pour les fournisseurs.
     *
     * @return Le choix du fournisseur.
     */

    public int afficherMenuPrincipalFournisseur() {
        System.out.println("");
        System.out.println("Menu principal");
        System.out.println("1. Modifier son profil");
        System.out.println("2. Gestion composantes");
        System.out.println("3. Quitter Robotix");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche les options de modification pour un utilisateur.
     *
     * @param utilisateur L'utilisateur à modifier.
     * @return Le choix de modification.
     */

    public int afficherOptionsModificationUtilisateur(Utilisateur utilisateur) {
        System.out.println("");
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1. Nom: " + utilisateur.getNom());
        System.out.println("2. Prénom: " + utilisateur.getPrenom());
        System.out.println("3. Pseudo: " + utilisateur.getPseudo());
        System.out.println("4. Mot de passe: " + utilisateur.getMotDePasse());
        System.out.println("5. Téléphone: " + utilisateur.getTelephone());
        System.out.println("6. Nom de compagnie: " + utilisateur.getNomDeCompagnie());
        System.out.println("7. Retour");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche les options de modification pour un fournisseur.
     *
     * @param fournisseur Le fournisseur à modifier.
     * @return Le choix de modification.
     */

    public int afficherOptionsModificationFournisseur(Fournisseur fournisseur) {
        System.out.println("");
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1. Pseudo: " + fournisseur.getPseudo());
        System.out.println("2. Mot de passe: " + fournisseur.getMotDePasse());
        System.out.println("3. Téléphone: " + fournisseur.getTelephone());
        System.out.println("4. Capacité de fabrication: " + fournisseur.getCapaciteFabrication());
        System.out.println("5. Retour");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche les options de modification pour une composante.
     *
     * @param composante La composante à modifier.
     * @return Le choix de modification.
     */

    public int afficherOptionsModificationComposante(Composante composante) {
        System.out.println("");
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1. Nom: " + composante.getNom());
        System.out.println("2. Description: " + composante.getDescription());
        System.out.println("3. Prix: " + composante.getPrix());
        System.out.println("4. Type: " + composante.getType());
        System.out.println("5. Disponibilité: " + composante.getIsDisponible());
        System.out.println("6. Retour");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu de gestion des robots.
     *
     * @return Le choix de gestion.
     */

    public int afficherMenuGestionRobots() {
        System.out.println("");
        System.out.println("Gestion des robots");
        System.out.println("1. Enregistrer un robot");
        System.out.println("2. Supprimer un robot");
        System.out.println("3. Afficher l'état de mes robots");
        System.out.println("4. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu d'achat des composantes.
     *
     * @return Le choix de gestion.
     */

    public int afficherMenuAchatComposantes() {
        System.out.println("");
        System.out.println("Gestion composantes");
        System.out.println("1. Voir mes composantes");
        System.out.println("2. Liste des composantes disponibles");
        System.out.println("3. Recherche d'une composante");
        System.out.println("4. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu de gestion des composantes pour les fournisseurs.
     *
     * @return Le choix de gestion.
     */

    public int afficherMenuGestionComposantesFournisseur() {
        System.out.println("");
        System.out.println("Gestion des composantes");
        System.out.println("1. Enregistrer une composante");
        System.out.println("2. Modifier une composante");
        System.out.println("3. Supprimer une composante");
        System.out.println("4. Voir mes composantes");
        System.out.println("5. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche les composantes dans l'inventaire.
     *
     * @param composantes La liste des composantes à afficher.
     */

    public void afficherComposantes(List<Composante> composantes) {
        System.out.println("");
        System.out.println("Composantes dans votre inventaire :");
        if (composantes.isEmpty()) {
            System.out.println("Aucune composante dans l'inventaire.");
        } else {
            for (Composante composante : composantes) {
                System.out.println("Nom : " + composante.getNom());
                System.out.println("Description : " + composante.getDescription());
                System.out.println("Prix : " + composante.getPrix());
                System.out.println("Type : " + composante.getType());
                System.out.println("--------------------");
            }
        }
    }

    /**
     * Affiche les détails et retourne l'entrée de l'utilisateur.
     *
     * @param prompt Le message d'invite pour l'utilisateur.
     * @return L'entrée de l'utilisateur.
     */

    public String getDetail(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.next();
    }

    /**
     * Affiche les composantes disponibles.
     *
     * @param composantes La liste des composantes disponibles.
     */

    public void afficherComposantesDisponibles(List<Composante> composantes) {
        for (int i = 0; i < composantes.size(); i++) {
            Composante composante = composantes.get(i);
            System.out.println((i + 1) + ". " + composante.getNom() + " (" + composante.getType() + ")");
        }
    }

    /**
     * Affiche et choisit une composante.
     *
     * @param composantes La liste des composantes à choisir.
     * @return Le numéro de la composante choisie.
     */

    public int afficherEtChoisirComposante(List<Composante> composantes) {
        afficherComposantesDisponibles(composantes);
        return Integer.parseInt(getDetail("Entrez le numéro de la composante"));
    }

    /**
     * Affiche et choisit un robot.
     *
     * @param robots La liste des robots à choisir.
     * @return Le numéro du robot choisi.
     */

    public int afficherEtChoisirRobot(List<Robot> robots) {
        System.out.println("Sélectionnez le robot :");
        for (int i = 0; i < robots.size(); i++) {
            System.out.println((i + 1) + ". " + robots.get(i).getNom());
        }
        return Integer.parseInt(getDetail("Entrez le numéro du robot"));
    }

    /**
     * Affiche le menu de gestion des activités.
     *
     * @return Le choix de gestion.
     */

    public int afficherMenuGestionActivites() {
        System.out.println("");
        System.out.println("Gestion des activités");
        System.out.println("1. Créer une activité");
        System.out.println("2. Modifier une activité");
        System.out.println("3. Supprimer une activité");
        System.out.println("4. Assigner un robot à une activité");
        System.out.println("5. Afficher les activités des robots");
        System.out.println("0. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche les options de modification d'une activité.
     *
     * @param activite L'activité à modifier.
     * @return Le choix de modification.
     */

    public int afficherOptionsModificationActivite(Activite activite) {
        System.out.println("");
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1. Points: " + activite.getPoints());
        System.out.println("2. Date de début: " + activite.getDateDebut());
        System.out.println("3. Date de fin: " + activite.getDateFin());
        System.out.println("4. Retour");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu de gestion des abonnements.
     *
     * @return Le choix de gestion.
     */

    public int afficherMenuGestionAbonnements() {
        System.out.println("");
        System.out.println("Gestion des abonnements");
        System.out.println("1. Voir mes followers");
        System.out.println("2. Voir les comptes que je suis");
        System.out.println("3. Suivre un utilisateur");
        System.out.println("4. Arrêter de suivre un utilisateur");
        System.out.println("5. Retour");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche la liste des abonnés.
     *
     * @param titre   Le titre de la liste des abonnés.
     * @param abonnes La liste des abonnés.
     */

    public void afficherListeAbonnes(String titre, List<String> abonnes) {
        System.out.println(titre + " :");
        if (abonnes.isEmpty()) {
            System.out.println("Aucun " + titre.toLowerCase() + ".");
        } else {
            for (String abonne : abonnes) {
                System.out.println(abonne);
            }
        }
    }

}
