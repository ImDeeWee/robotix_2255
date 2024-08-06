package org.example.Controller;

import org.example.ComposanteUtil;
import org.example.ActiviteUtil;
import org.example.JsonUtil;
import org.example.RobotUtil;
import org.example.Model.Compte;
import org.example.Model.Activite;
import org.example.Model.CPU;
import org.example.Model.Composante;
import org.example.Model.ComposanteType;
import org.example.Model.Fournisseur;
import org.example.Model.Robot;
import org.example.Model.Utilisateur;
import org.example.View.MenuPrincipalView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Contrôleur principal pour le menu principal de l'application.
 */

public class MenuPrincipalController {
    private MenuPrincipalView view;
    private Compte compte;

    /**
     * Constructeur de MenuPrincipalController.
     * 
     * @param view   la vue associée au menu principal.
     * @param compte le compte de l'utilisateur connecté.
     */

    public MenuPrincipalController(MenuPrincipalView view, Compte compte) {
        this.view = view;
        this.compte = compte;
    }

    /**
     * Démarre le contrôleur et affiche le menu principal.
     */

    public void run() {
        boolean exit = false;
        while (!exit) {
            int choice;
            if (compte instanceof Utilisateur) {
                choice = view.afficherMenuPrincipalUtilisateur();
                exit = handleUtilisateurChoice(choice);
            } else if (compte instanceof Fournisseur) {
                choice = view.afficherMenuPrincipalFournisseur();
                exit = handleFournisseurChoice(choice);
            } else {
                System.out.println("Type de compte non reconnu.");
                exit = true;
            }
        }
    }

    /**
     * Gère les choix du menu pour un utilisateur.
     * 
     * @param choice le choix de l'utilisateur.
     * @return true si l'utilisateur souhaite quitter le menu, false sinon.
     */

    private boolean handleUtilisateurChoice(int choice) {
        switch (choice) {
            case 1:
                modifierProfilUtilisateur();
                break;
            case 2:
                afficherMenuGestionRobots();
                break;
            case 3:
                afficherMenuAchatComposantes();
                break;
            case 4:
                trouverFournisseur();
                break;
            case 5:
                gererActivites();
                break;
            case 6:
                gererAbonnements();
                break;
            case 7:
                // voirNotifications();
                break;
            case 8:
                return true;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
        return false;
    }

    /**
     * Gère les abonnements de l'utilisateur.
     */

    private void gererAbonnements() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherMenuGestionAbonnements();
            switch (choix) {
                case 1:
                    afficherFollowers();
                    break;
                case 2:
                    afficherFollowing();
                    break;
                case 3:
                    suivreUtilisateur();
                    break;
                case 4:
                    arreterDeSuivreUtilisateur();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche les abonnés (followers) de l'utilisateur.
     */

    private void afficherFollowers() {
        view.afficherListeAbonnes("Followers", ((Utilisateur) compte).getFollowers());
    }

    /**
     * Affiche les abonnements (following) de l'utilisateur.
     */

    private void afficherFollowing() {
        view.afficherListeAbonnes("Following", ((Utilisateur) compte).getFollowing());
    }

    /**
     * Permet à l'utilisateur de suivre un autre utilisateur.
     */

    private void suivreUtilisateur() {
        Utilisateur utilisateur = (Utilisateur) compte;
        String pseudoASuivre = view.getDetail("Entrez le pseudo de l'utilisateur à suivre");

        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier("Application\\src\\main\\java\\Donnees\\Comptes.json");
        if (comptes != null) {
            boolean utilisateurExiste = false;
            for (Compte c : comptes) {
                if (c.getPseudo().equals(pseudoASuivre) && c instanceof Utilisateur) {
                    utilisateurExiste = true;
                    Utilisateur utilisateurASuivre = (Utilisateur) c;

                    utilisateur.addFollowing(pseudoASuivre);

                    utilisateurASuivre.addFollower(utilisateur.getPseudo());

                    for (int i = 0; i < comptes.size(); i++) {
                        if (comptes.get(i).getCourriel().equals(utilisateur.getCourriel())) {
                            comptes.set(i, utilisateur);
                        }
                        if (comptes.get(i).getCourriel().equals(utilisateurASuivre.getCourriel())) {
                            comptes.set(i, utilisateurASuivre);
                        }
                    }

                    JsonUtil.ecrireComptesDansFichier(comptes, "Application\\src\\main\\java\\Donnees\\Comptes.json");
                    System.out.println("Vous suivez maintenant " + pseudoASuivre);
                    break;
                }
            }
            if (!utilisateurExiste) {
                System.out.println("Utilisateur non trouvé.");
            }
        } else {
            System.out.println("Erreur lors de la lecture des comptes.");
        }
    }

    /**
     * Permet à l'utilisateur d'arrêter de suivre un autre utilisateur.
     */

    private void arreterDeSuivreUtilisateur() {
        Utilisateur utilisateur = (Utilisateur) compte;
        List<String> following = utilisateur.getFollowing();
        if (following.isEmpty()) {
            System.out.println("Vous ne suivez aucun utilisateur.");
            return;
        }

        System.out.println("Sélectionnez l'utilisateur à ne plus suivre :");
        for (int i = 0; i < following.size(); i++) {
            System.out.println((i + 1) + ". " + following.get(i));
        }
        int choix = Integer.parseInt(view.getDetail("Entrez le numéro de l'utilisateur à ne plus suivre"));

        if (choix < 1 || choix > following.size()) {
            System.out.println("Choix invalide. Opération annulée.");
            return;
        }

        String pseudoNePlusSuivre = following.get(choix - 1);
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier("Application\\src\\main\\java\\Donnees\\Comptes.json");
        if (comptes != null) {
            for (Compte c : comptes) {
                if (c.getPseudo().equals(pseudoNePlusSuivre) && c instanceof Utilisateur) {
                    ((Utilisateur) c).removeFollower(utilisateur.getPseudo());
                    break;
                }
            }

            utilisateur.removeFollowing(pseudoNePlusSuivre);

            for (int i = 0; i < comptes.size(); i++) {
                if (comptes.get(i).getCourriel().equals(utilisateur.getCourriel())) {
                    comptes.set(i, utilisateur);
                    break;
                }
            }

            JsonUtil.ecrireComptesDansFichier(comptes, "Application\\src\\main\\java\\Donnees\\Comptes.json");
            System.out.println("Vous ne suivez plus " + pseudoNePlusSuivre);
        } else {
            System.out.println("Erreur lors de la lecture des comptes.");
        }
    }

    /**
     * Gère les activités de l'utilisateur.
     */

    private void gererActivites() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherMenuGestionActivites();
            switch (choix) {
                case 1:
                    creerActivite();
                    break;
                case 2:
                    modifierActivite();
                    break;
                case 3:
                    supprimerActivite();
                    break;
                case 4:
                    assignerRobotActivite();
                    break;
                case 5:
                    afficherActivitesRobots();
                    break;
                case 0:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche les activités assignées aux robots de l'utilisateur.
     */

    private void afficherActivitesRobots() {
        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        Map<String, List<Robot>> robots = RobotUtil
                .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");

        if (activites != null && robots != null && robots.containsKey(compte.getCourriel())) {
            List<Robot> robotsUtilisateur = robots.get(compte.getCourriel());
            if (robotsUtilisateur.isEmpty()) {
                System.out.println("Aucun robot trouvé pour cet utilisateur.");
                return;
            }

            for (Robot robot : robotsUtilisateur) {
                System.out.println("Activités pour le robot numéro de série : " + robot.getNumeroDeSerie());
                for (Map.Entry<String, List<Activite>> entry : activites.entrySet()) {
                    for (Activite activite : entry.getValue()) {
                        if (activite.getNumeroDeSerieRobots().contains(robot.getNumeroDeSerie())) {
                            System.out.println("Activité : " + activite.getNom());
                        }
                    }
                }
            }

            int choix = Integer.parseInt(view.getDetail("Entrez 1 pour désinscrire un robot ou 0 pour revenir"));

            if (choix == 1) {
                desinscrireRobotActivite();
            }
        } else {
            System.out.println("Aucune activité trouvée pour cet utilisateur.");
        }
    }

    /**
     * Désinscrit un robot d'une activité.
     */

    private void desinscrireRobotActivite() {
        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        Map<String, List<Robot>> robots = RobotUtil
                .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");

        if (activites != null && robots != null && robots.containsKey(compte.getCourriel())) {
            List<Robot> robotsUtilisateur = robots.get(compte.getCourriel());
            if (robotsUtilisateur.isEmpty()) {
                System.out.println("Aucun robot trouvé pour cet utilisateur.");
                return;
            }

            System.out.println("Sélectionnez le robot à désinscrire :");
            for (int i = 0; i < robotsUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". Numéro de série : " + robotsUtilisateur.get(i).getNumeroDeSerie());
            }
            int choixRobot = Integer.parseInt(view.getDetail("Entrez le numéro du robot"));

            if (choixRobot < 1 || choixRobot > robotsUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Robot robot = robotsUtilisateur.get(choixRobot - 1);

            System.out.println("Sélectionnez l'activité à partir de laquelle désinscrire le robot :");
            List<Activite> activitesAvecRobot = new ArrayList<>();
            for (Map.Entry<String, List<Activite>> entry : activites.entrySet()) {
                for (Activite activite : entry.getValue()) {
                    if (activite.getNumeroDeSerieRobots().contains(robot.getNumeroDeSerie())) {
                        activitesAvecRobot.add(activite);
                    }
                }
            }

            for (int i = 0; i < activitesAvecRobot.size(); i++) {
                System.out.println((i + 1) + ". " + activitesAvecRobot.get(i).toString());
            }
            int choixActivite = Integer.parseInt(view.getDetail("Entrez le numéro de l'activité"));

            if (choixActivite < 1 || choixActivite > activitesAvecRobot.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Activite activite = activitesAvecRobot.get(choixActivite - 1);
            activite.removeNumeroDeSerieRobot(robot.getNumeroDeSerie());

            ActiviteUtil.ecrireActivitesDansFichier(activites, "Application\\src\\main\\java\\Donnees\\Activites.json");
            System.out.println("Robot désinscrit de l'activité avec succès.");
        } else {
            System.out.println("Aucune activité trouvée pour cet utilisateur.");
        }
    }

    /**
     * Assigne un robot à une activité.
     */

    private void assignerRobotActivite() {
        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        if (activites != null && activites.containsKey(compte.getCourriel())) {
            List<Activite> activitesUtilisateur = activites.get(compte.getCourriel());
            if (activitesUtilisateur.isEmpty()) {
                System.out.println("Aucune activité disponible.");
                return;
            }

            System.out.println("Sélectionnez l'activité à laquelle vous voulez assigner un robot :");
            for (int i = 0; i < activitesUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". " + activitesUtilisateur.get(i).toString());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro de l'activité"));

            if (choix < 1 || choix > activitesUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Activite activite = activitesUtilisateur.get(choix - 1);
            boolean retour = false;
            while (!retour) {
                System.out.println("Détails de l'activité :");
                System.out.println("Points : " + activite.getPoints());
                System.out.println("Date de début : " + activite.getDateDebut());
                System.out.println("Date de fin : " + activite.getDateFin());
                System.out.println("Tâches : " + activite.getTaches());
                System.out.println("Robots assignés : " + activite.getNumeroDeSerieRobots());
                System.out.println("1. Assigner un robot");
                System.out.println("0. Retour");

                int choixModif = Integer.parseInt(view.getDetail("Entrez votre choix"));

                if (choixModif == 1) {
                    assignerRobot(activite);
                } else if (choixModif == 0) {
                    retour = true;
                } else {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

            ActiviteUtil.ecrireActivitesDansFichier(activites, "Application\\src\\main\\java\\Donnees\\Activites.json");
        } else {
            System.out.println("Aucune activité trouvée pour cet utilisateur.");
        }
    }

    /**
     * Assigne un robot spécifique à une activité.
     * 
     * @param activite l'activité à laquelle le robot sera assigné.
     */

    private void assignerRobot(Activite activite) {
        Map<String, List<Robot>> robots = RobotUtil
                .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");
        if (robots != null && robots.containsKey(compte.getCourriel())) {
            List<Robot> robotsUtilisateur = robots.get(compte.getCourriel());
            if (robotsUtilisateur.isEmpty()) {
                System.out.println("Aucun robot disponible.");
                return;
            }

            System.out.println("Sélectionnez le robot à assigner :");
            for (int i = 0; i < robotsUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". Numéro de série : " + robotsUtilisateur.get(i).getNumeroDeSerie());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro du robot"));

            if (choix < 1 || choix > robotsUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Robot robot = robotsUtilisateur.get(choix - 1);
            activite.addNumeroDeSerieRobot(robot.getNumeroDeSerie());
            System.out.println("Robot assigné avec succès.");
        } else {
            System.out.println("Erreur lors de la lecture des robots.");
        }
    }

    /**
     * Crée une nouvelle activité.
     */

    private void creerActivite() {
        String nom = view.getDetail("Entrez le nom de l'activité");
        int points = Integer.parseInt(view.getDetail("Entrez le nombre de points"));
        LocalDate dateDebut = LocalDate.parse(view.getDetail("Entrez la date de début (YYYY-MM-DD)"));
        LocalDate dateFin = LocalDate.parse(view.getDetail("Entrez la date de fin (YYYY-MM-DD)"));

        Activite activite = new Activite(nom, points, dateDebut, dateFin);
        activite.addAuteur(compte);

        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        if (activites != null) {
            List<Activite> activitesUtilisateur = activites.getOrDefault(compte.getCourriel(), new ArrayList<>());
            activitesUtilisateur.add(activite);
            activites.put(compte.getCourriel(), activitesUtilisateur);
            ActiviteUtil.ecrireActivitesDansFichier(activites, "Application\\src\\main\\java\\Donnees\\Activites.json");
            System.out.println("Activité créée avec succès.");
        } else {
            System.out.println("Erreur lors de la lecture des activités.");
        }
    }

    /**
     * Modifie une activité existante.
     */

    private void modifierActivite() {
        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        if (activites != null && activites.containsKey(compte.getCourriel())) {
            List<Activite> activitesUtilisateur = activites.get(compte.getCourriel());
            if (activitesUtilisateur.isEmpty()) {
                System.out.println("Aucune activité disponible à modifier.");
                return;
            }

            System.out.println("Sélectionnez l'activité à modifier :");
            for (int i = 0; i < activitesUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". " + activitesUtilisateur.get(i).toString());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro de l'activité à modifier"));

            if (choix < 1 || choix > activitesUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Activite activite = activitesUtilisateur.get(choix - 1);
            boolean retour = false;
            while (!retour) {
                int choixModif = view.afficherOptionsModificationActivite(activite);
                switch (choixModif) {
                    case 1:
                        activite.setPoints(Integer.parseInt(view.getDetail("Entrez le nouveau nombre de points")));
                        break;
                    case 2:
                        try {
                            activite.setDateDebut(
                                    LocalDate.parse(view.getDetail("Entrez la nouvelle date de début (YYYY-MM-DD)"),
                                            DateTimeFormatter.ISO_LOCAL_DATE));
                        } catch (DateTimeParseException e) {
                            System.out.println("Format de date invalide. Veuillez réessayer.");
                        }
                        break;
                    case 3:
                        try {
                            activite.setDateFin(
                                    LocalDate.parse(view.getDetail("Entrez la nouvelle date de fin (YYYY-MM-DD)"),
                                            DateTimeFormatter.ISO_LOCAL_DATE));
                        } catch (DateTimeParseException e) {
                            System.out.println("Format de date invalide. Veuillez réessayer.");
                        }
                        break;
                    case 4:
                        retour = true;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

            ActiviteUtil.ecrireActivitesDansFichier(activites, "Application\\src\\main\\java\\Donnees\\Activites.json");
            System.out.println("Activité modifiée avec succès.");
        } else {
            System.out.println("Aucune activité trouvée pour cet utilisateur.");
        }
    }

    /**
     * Supprime une activité existante.
     */

    private void supprimerActivite() {
        Map<String, List<Activite>> activites = ActiviteUtil
                .lireActivitesDepuisFichier("Application\\src\\main\\java\\Donnees\\Activites.json");
        if (activites != null && activites.containsKey(compte.getCourriel())) {
            List<Activite> activitesUtilisateur = activites.get(compte.getCourriel());
            if (activitesUtilisateur.isEmpty()) {
                System.out.println("Aucune activité disponible à supprimer.");
                return;
            }

            System.out.println("Sélectionnez l'activité à supprimer :");
            for (int i = 0; i < activitesUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". " + activitesUtilisateur.get(i).toString());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro de l'activité à supprimer"));

            if (choix < 1 || choix > activitesUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            activitesUtilisateur.remove(choix - 1);
            ActiviteUtil.ecrireActivitesDansFichier(activites, "Application\\src\\main\\java\\Donnees\\Activites.json");
            System.out.println("Activité supprimée avec succès.");
        } else {
            System.out.println("Aucune activité trouvée pour cet utilisateur.");
        }
    }

    /**
     * Gère les choix du menu pour un fournisseur.
     * 
     * @param choice le choix du fournisseur.
     * @return true si le fournisseur souhaite quitter le menu, false sinon.
     */

    private boolean handleFournisseurChoice(int choice) {
        switch (choice) {
            case 1:
                modifierProfilFournisseur();
                break;
            case 2:
                afficherMenuGestionComposantes();
                break;
            case 3:
                return true;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
        return false;
    }

    /**
     * Modifie le profil de l'utilisateur.
     */

    private void modifierProfilUtilisateur() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherOptionsModificationUtilisateur((Utilisateur) compte);
            switch (choix) {
                case 1:
                    ((Utilisateur) compte).setNom(view.getDetail("Entrez le nouveau nom"));
                    break;
                case 2:
                    ((Utilisateur) compte).setPrenom(view.getDetail("Entrez le nouveau prénom"));
                    break;
                case 3:
                    ((Utilisateur) compte).setPseudo(view.getDetail("Entrez le nouveau pseudo"));
                    break;
                case 4:
                    ((Utilisateur) compte).setMotDePasse(view.getDetail("Entrez le nouveau mot de passe"));
                    break;
                case 5:
                    ((Utilisateur) compte).setTelephone(view.getDetail("Entrez le nouveau téléphone"));
                    break;
                case 6:
                    ((Utilisateur) compte).setNomDeCompagnie(view.getDetail("Entrez le nouveau nom de compagnie"));
                    break;
                case 7:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        mettreAJourCompte();
    }

    /**
     * Modifie le profil du fournisseur.
     */

    private void modifierProfilFournisseur() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherOptionsModificationFournisseur((Fournisseur) compte);
            switch (choix) {
                case 1:
                    ((Fournisseur) compte).setPseudo(view.getDetail("Entrez le nouveau pseudo"));
                    break;
                case 2:
                    ((Fournisseur) compte).setMotDePasse(view.getDetail("Entrez le nouveau mot de passe"));
                    break;
                case 3:
                    ((Fournisseur) compte).setTelephone(view.getDetail("Entrez le nouveau téléphone"));
                    break;
                case 4:
                    ((Fournisseur) compte).setCapaciteFabrication(
                            Integer.parseInt(view.getDetail("Entrez la nouvelle capacité de fabrication")));
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        mettreAJourCompte();
    }

    /**
     * Met à jour le compte dans le fichier JSON.
     */

    private void mettreAJourCompte() {
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier("Application\\src\\main\\java\\Donnees\\Comptes.json");
        if (comptes != null) {
            boolean compteTrouve = false;
            String ancienPseudo = null;
            if (compte instanceof Utilisateur) {
                ancienPseudo = ((Utilisateur) compte).getPseudo();
            }
            for (int i = 0; i < comptes.size(); i++) {
                if (comptes.get(i).getCourriel().equals(compte.getCourriel())) {
                    comptes.set(i, compte);
                    compteTrouve = true;
                } else if (ancienPseudo != null) {
                    Compte autreCompte = comptes.get(i);
                    if (autreCompte instanceof Utilisateur) {
                        Utilisateur utilisateur = (Utilisateur) autreCompte;
                        if (utilisateur.getFollowers().contains(ancienPseudo)) {
                            utilisateur.getFollowers().remove(ancienPseudo);
                            utilisateur.getFollowers().add(((Utilisateur) compte).getPseudo());
                        }
                        if (utilisateur.getFollowing().contains(ancienPseudo)) {
                            utilisateur.getFollowing().remove(ancienPseudo);
                            utilisateur.getFollowing().add(((Utilisateur) compte).getPseudo());
                        }
                    }
                }
            }
            if (compteTrouve) {
                JsonUtil.ecrireComptesDansFichier(comptes, "Application\\src\\main\\java\\Donnees\\Comptes.json");
            } else {
                System.out.println("Erreur: compte non trouvé dans la liste.");
            }
        } else {
            System.out.println("Erreur lors de la lecture des comptes.");
        }
    }

    /**
     * Affiche le menu de gestion des robots.
     */

    private void afficherMenuGestionRobots() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherMenuGestionRobots();
            switch (choix) {
                case 1:
                    enregistrerRobot();
                    break;
                case 2:
                    supprimerRobot();
                    break;
                case 3:
                    afficherEtatRobots();
                    break;
                case 4:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche l'état des robots de l'utilisateur.
     */

    private void afficherEtatRobots() {
        Map<String, List<Robot>> robotsInventaires = RobotUtil
                .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");
        List<Robot> robotsUtilisateur = robotsInventaires.get(compte.getCourriel());

        if (robotsUtilisateur != null && !robotsUtilisateur.isEmpty()) {
            System.out.println("Liste des robots :");
            for (int i = 0; i < robotsUtilisateur.size(); i++) {
                Robot robot = robotsUtilisateur.get(i);
                System.out.println((i + 1) + ". Nom : " + robot.getNom() + ", Type : " + robot.getType()
                        + ", Niveau de batterie : " + robot.getNiveauBatterie());
            }

            int choix = Integer.parseInt(
                    view.getDetail("Entrez le numéro du robot pour voir les détails complets ou 0 pour revenir"));

            if (choix > 0 && choix <= robotsUtilisateur.size()) {
                Robot robotChoisi = robotsUtilisateur.get(choix - 1);
                afficherDetailsRobot(robotChoisi);
            }
        } else {
            System.out.println("Aucun robot trouvé dans votre inventaire.");
        }
    }

    /**
     * Affiche les détails d'un robot spécifique.
     * 
     * @param robot le robot dont les détails seront affichés.
     */

    private void afficherDetailsRobot(Robot robot) {
        System.out.println("Détails du robot :");
        System.out.println("Nom : " + robot.getNom());
        System.out.println("Type : " + robot.getType());
        System.out.println("Niveau de batterie : " + robot.getNiveauBatterie());
        System.out.println("Numéro de série : " + robot.getNumeroDeSerie());
        System.out.println("Position : " + robot.getPosition());
        System.out.println("Vitesse : " + robot.getVitesse());
        System.out.println("Consommation CPU : " + robot.getConsoCPU());
        System.out.println("Mémoire : " + robot.getMemoire());
        System.out.println("Composantes : ");
        for (Composante composante : robot.getComposantesRobot()) {
            System.out.println("- " + composante.getNom() + " (" + composante.getType() + ")");
        }
        int choix = Integer.parseInt(view.getDetail("Entrez 0 pour revenir"));
        if (choix != 0) {
            System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    /**
     * Supprime un robot de l'inventaire de l'utilisateur.
     */

    private void supprimerRobot() {
        Map<String, List<Robot>> robotsInventaires = RobotUtil
                .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");
        List<Robot> robotsUtilisateur = robotsInventaires.get(compte.getCourriel());

        if (robotsUtilisateur != null && !robotsUtilisateur.isEmpty()) {
            System.out.println("Sélectionnez le robot à supprimer :");
            for (int i = 0; i < robotsUtilisateur.size(); i++) {
                System.out.println((i + 1) + ". " + robotsUtilisateur.get(i).getNom());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro du robot à supprimer"));

            if (choix < 1 || choix > robotsUtilisateur.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Robot robotASupprimer = robotsUtilisateur.get(choix - 1);
            robotsUtilisateur.remove(robotASupprimer);
            robotsInventaires.put(compte.getCourriel(), robotsUtilisateur);

            RobotUtil.ecrireRobotsDansFichier(robotsInventaires, "Application\\src\\main\\java\\Donnees\\Robots.json");
            System.out.println("Robot supprimé avec succès.");
        } else {
            System.out.println("Aucun robot trouvé dans votre inventaire.");
        }
    }

    /**
     * Enregistre un nouveau robot pour l'utilisateur.
     */

    private void enregistrerRobot() {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        List<Composante> composantesUtilisateur = inventaires.get(compte.getCourriel());

        if (composantesUtilisateur != null) {
            List<CPU> cpus = composantesUtilisateur.stream()
                    .filter(c -> c instanceof CPU && c.getIsDisponible())
                    .map(c -> (CPU) c)
                    .collect(Collectors.toList());

            List<Composante> autresComposantes = composantesUtilisateur.stream()
                    .filter(c -> !(c instanceof CPU) && c.getIsDisponible())
                    .collect(Collectors.toList());

            if (cpus.isEmpty()) {
                System.out.println("Erreur : Vous devez avoir au moins un CPU pour enregistrer un robot.");
                return;
            }

            if (autresComposantes.isEmpty()) {
                System.out
                        .println("Erreur : Vous devez avoir au moins une autre composante pour enregistrer un robot.");
                return;
            }

            String nom = view.getDetail("Entrez le nom du robot");
            String type = view.getDetail("Entrez le type du robot");
            String position = view.getDetail("Entrez la position du robot");
            String vitesse = view.getDetail("Entrez la vitesse du robot");
            String niveauBatterie = view.getDetail("Entrez le niveau de batterie du robot");
            String consoCPU = view.getDetail("Entrez la consommation CPU du robot");
            String memoire = view.getDetail("Entrez la mémoire du robot");

            System.out.println("Sélectionnez le CPU pour le robot :");
            for (int i = 0; i < cpus.size(); i++) {
                System.out.println((i + 1) + ". CPU avec numéro de série : " + cpus.get(i).getNumeroDeSerie());
            }
            int choixCpu = Integer.parseInt(view.getDetail("Entrez le numéro du CPU"));

            if (choixCpu < 1 || choixCpu > cpus.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            CPU cpuSelectionne = cpus.get(choixCpu - 1);
            cpuSelectionne.setIsDisponible(false);

            Robot nouveauRobot = new Robot(cpuSelectionne, nom, type, position, vitesse, niveauBatterie, consoCPU,
                    memoire);

            System.out.println("Sélectionnez les autres composantes pour le robot :");
            for (int i = 0; i < autresComposantes.size(); i++) {
                System.out.println((i + 1) + ". " + autresComposantes.get(i).getNom() + " ("
                        + autresComposantes.get(i).getType() + ")");
            }
            String choixComposantes = view.getDetail("Entrez les numéros des composantes séparés par des virgules");

            for (String index : choixComposantes.split(",")) {
                int i = Integer.parseInt(index.trim()) - 1;
                if (i >= 0 && i < autresComposantes.size()) {
                    Composante composanteSelectionnee = autresComposantes.get(i);
                    composanteSelectionnee.setIsDisponible(false);
                    nouveauRobot.addComposante(composanteSelectionnee);
                } else {
                    System.out.println("Choix invalide pour la composante " + (i + 1) + ". Ignorée.");
                }
            }

            Map<String, List<Robot>> robotsInventaires = RobotUtil
                    .lireRobotsDepuisFichier("Application\\src\\main\\java\\Donnees\\Robots.json");
            List<Robot> robotsUtilisateur = robotsInventaires.getOrDefault(compte.getCourriel(), new ArrayList<>());
            robotsUtilisateur.add(nouveauRobot);
            robotsInventaires.put(compte.getCourriel(), robotsUtilisateur);
            RobotUtil.ecrireRobotsDansFichier(robotsInventaires, "Application\\src\\main\\java\\Donnees\\Robots.json");

            inventaires.put(compte.getCourriel(), composantesUtilisateur);
            ComposanteUtil.ecrireComposantesDansFichier(inventaires,
                    "Application\\src\\main\\java\\Donnees\\Composantes.json");

            System.out.println("Robot enregistré avec succès.");
        } else {
            System.out.println("Aucune composante trouvée pour ce compte.");
        }
    }

    /**
     * Affiche le menu d'achat de composantes.
     */

    private void afficherMenuAchatComposantes() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherMenuAchatComposantes();
            switch (choix) {
                case 1:
                    voirMesComposantes();
                    break;
                case 2:
                    listeComposantesDisponibles();
                    break;
                case 3:
                    // rechercheComposante();
                    break;
                case 4:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche le menu de gestion des composantes pour les fournisseurs.
     */

    private void afficherMenuGestionComposantes() {
        boolean retour = false;
        while (!retour) {
            int choix = view.afficherMenuGestionComposantesFournisseur();
            switch (choix) {
                case 1:
                    enregistrerComposante();
                    break;
                case 2:
                    modifierComposante();
                    break;
                case 3:
                    supprimerComposante();
                    break;
                case 4:
                    voirMesComposantes();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche les composantes de l'utilisateur.
     */

    private void voirMesComposantes() {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null && inventaires.containsKey(compte.getCourriel())) {
            List<Composante> composantes = inventaires.get(compte.getCourriel());
            view.afficherComposantes(composantes);
        } else {
            System.out.println("Aucune composante trouvée pour ce compte.");
        }
    }

    /**
     * Enregistre une nouvelle composante.
     */

    private void enregistrerComposante() {
        String nom = view.getDetail("Entrez le nom de la composante");
        String description = view.getDetail("Entrez la description de la composante");
        double prix = Double.parseDouble(view.getDetail("Entrez le prix de la composante"));
        String typeStr = view.getDetail(
                "Entrez le type de la composante (CPU, ROUES, BRAS, HELICE, HAUTPARLEUR, MICRO, ECRANTXT, ECRANGUI)");
        ComposanteType type = ComposanteType.valueOf(typeStr);
        boolean isDisponible = Boolean.parseBoolean(view.getDetail("La composante est-elle disponible ? (true/false)"));

        Composante nouvelleComposante;
        if (type == ComposanteType.CPU) {
            int numeroDeSerie = Integer.parseInt(view.getDetail("Entrez le numéro de série du CPU"));
            nouvelleComposante = new CPU(nom, description, prix, isDisponible, numeroDeSerie);
        } else {
            nouvelleComposante = new Composante(nom, description, prix, type, isDisponible);
        }

        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null) {
            List<Composante> composantes = inventaires.getOrDefault(compte.getCourriel(), new ArrayList<>());
            composantes.add(nouvelleComposante);
            inventaires.put(compte.getCourriel(), composantes);
            ComposanteUtil.ecrireComposantesDansFichier(inventaires,
                    "Application\\src\\main\\java\\Donnees\\Composantes.json");
            System.out.println("Composante enregistrée avec succès.");
        } else {
            System.out.println("Erreur lors de la lecture des inventaires.");
        }
    }

    /**
     * Modifie une composante existante.
     */

    private void modifierComposante() {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null && inventaires.containsKey(compte.getCourriel())) {
            List<Composante> composantes = inventaires.get(compte.getCourriel());
            if (composantes.isEmpty()) {
                System.out.println("Aucune composante disponible à modifier.");
                return;
            }

            System.out.println("Sélectionnez la composante à modifier :");
            for (int i = 0; i < composantes.size(); i++) {
                System.out.println((i + 1) + ". " + composantes.get(i).getNom());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro de la composante à modifier"));

            if (choix < 1 || choix > composantes.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            Composante composante = composantes.get(choix - 1);
            boolean retour = false;
            while (!retour) {
                int choixModif = view.afficherOptionsModificationComposante(composante);
                switch (choixModif) {
                    case 1:
                        composante.setNom(view.getDetail("Entrez le nouveau nom"));
                        break;
                    case 2:
                        composante.setDescription(view.getDetail("Entrez la nouvelle description"));
                        break;
                    case 3:
                        composante.setPrix(Double.parseDouble(view.getDetail("Entrez le nouveau prix")));
                        break;
                    case 4:
                        composante.setType(ComposanteType.valueOf(view.getDetail(
                                "Entrez le nouveau type (CPU, ROUES, BRAS, HELICE, HAUTPARLEUR, MICRO, ECRANTXT, ECRANGUI)")));
                        break;
                    case 5:
                        composante.setIsDisponible(Boolean
                                .parseBoolean(view.getDetail("La composante est-elle disponible ? (true/false)")));
                        break;
                    case 6:
                        retour = true;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

            ComposanteUtil.ecrireComposantesDansFichier(inventaires,
                    "Application\\src\\main\\java\\Donnees\\Composantes.json");
            System.out.println("Composante modifiée avec succès.");
        } else {
            System.out.println("Aucune composante trouvée pour cet utilisateur.");
        }
    }

    /**
     * Supprime une composante existante.
     */

    private void supprimerComposante() {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null && inventaires.containsKey(compte.getCourriel())) {
            List<Composante> composantes = inventaires.get(compte.getCourriel());
            if (composantes.isEmpty()) {
                System.out.println("Aucune composante disponible à supprimer.");
                return;
            }

            System.out.println("Sélectionnez la composante à supprimer :");
            for (int i = 0; i < composantes.size(); i++) {
                System.out.println((i + 1) + ". " + composantes.get(i).getNom());
            }
            int choix = Integer.parseInt(view.getDetail("Entrez le numéro de la composante à supprimer"));

            if (choix < 1 || choix > composantes.size()) {
                System.out.println("Choix invalide. Opération annulée.");
                return;
            }

            composantes.remove(choix - 1);
            ComposanteUtil.ecrireComposantesDansFichier(inventaires,
                    "Application\\src\\main\\java\\Donnees\\Composantes.json");
            System.out.println("Composante supprimée avec succès.");
        } else {
            System.out.println("Aucune composante trouvée pour cet utilisateur.");
        }
    }

    /**
     * Affiche la liste des composantes disponibles des fournisseurs.
     */

    private void listeComposantesDisponibles() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper
                    .readTree(new File("Application\\src\\main\\java\\Donnees\\Composantes.json"));
            JsonNode inventairesNode = rootNode.get("inventaires");
            if (inventairesNode != null) {
                System.out.println("Composantes disponibles des fournisseurs :");
                List<JsonNode> composantesDisponibles = new ArrayList<>();
                int index = 1; // Initialiser l'index pour la numérotation
                for (JsonNode inventaireNode : inventairesNode) {
                    boolean isFournisseur = inventaireNode.get("isFournisseur").asBoolean();
                    if (isFournisseur) {
                        String courrielFournisseur = inventaireNode.get("courriel").asText();
                        for (JsonNode composanteNode : inventaireNode.get("composantes")) {
                            ((ObjectNode) composanteNode).put("courrielFournisseur", courrielFournisseur);
                            String nom = composanteNode.get("nom").asText();
                            boolean isDisponible = composanteNode.get("isDisponible").asBoolean();
                            if (isDisponible) {
                                composantesDisponibles.add(composanteNode);
                                System.out.println(index + ". Nom : " + nom + ", Fournisseur : " + courrielFournisseur);
                                index++; // Incrémenter l'index après chaque composante
                            }
                        }
                    }
                }

                if (!composantesDisponibles.isEmpty()) {
                    int choix = Integer.parseInt(view
                            .getDetail("Entrez le numéro de la composante pour voir les détails ou 0 pour revenir"));
                    if (choix > 0 && choix <= composantesDisponibles.size()) {
                        JsonNode composanteChoisie = composantesDisponibles.get(choix - 1);
                        afficherDetailsComposantePourAchat(composanteChoisie);
                    }
                } else {
                    System.out.println("Aucune composante disponible trouvée.");
                }
            } else {
                System.out.println("Aucune composante disponible trouvée.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Affiche les détails d'une composante spécifique pour l'achat.
     * 
     * @param composanteNode le nœud JSON représentant la composante.
     */

    private void afficherDetailsComposantePourAchat(JsonNode composanteNode) {
        String nom = composanteNode.get("nom").asText();
        String description = composanteNode.get("description").asText();
        double prix = composanteNode.get("prix").asDouble();
        String type = composanteNode.get("type").asText();
        boolean isDisponible = composanteNode.get("isDisponible").asBoolean();
        String courrielFournisseur = composanteNode.get("courrielFournisseur").asText();
        Integer numeroDeSerie = type.equals("CPU") ? composanteNode.get("numeroDeSerie").asInt() : null;

        System.out.println("Nom : " + nom);
        System.out.println("Description : " + description);
        System.out.println("Prix : " + prix);
        System.out.println("Type : " + type);
        if (numeroDeSerie != null) {
            System.out.println("Numéro de série : " + numeroDeSerie);
        }
        System.out.println("Disponible : " + (isDisponible ? "Oui" : "Non"));

        int choix = Integer.parseInt(view.getDetail("Entrez 1 pour acheter cette composante ou 0 pour revenir"));
        if (choix == 1) {
            String confirmation = view.getDetail("Confirmez-vous l'achat ? (oui/non)");
            if ("oui".equalsIgnoreCase(confirmation)) {
                acheterComposante(courrielFournisseur, nom);
            }
        }
    }

    /**
     * Achète une composante spécifique.
     * 
     * @param courrielFournisseur le courriel du fournisseur.
     * @param nomComposante       le nom de la composante.
     */

    private void acheterComposante(String courrielFournisseur, String nomComposante) {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null) {
            List<Composante> composantesFournisseur = inventaires.get(courrielFournisseur);
            List<Composante> composantesUtilisateur = inventaires.getOrDefault(compte.getCourriel(), new ArrayList<>());

            for (Composante composante : composantesFournisseur) {
                if (composante.getNom().equals(nomComposante) && composante.getIsDisponible()) {
                    composante.setIsDisponible(false);
                    if (composante instanceof CPU) {
                        CPU cpu = (CPU) composante;
                        composantesUtilisateur.add(new CPU(cpu.getNom(), cpu.getDescription(), cpu.getPrix(), false,
                                cpu.getNumeroDeSerie()));
                    } else {
                        composantesUtilisateur.add(composante);
                    }
                    inventaires.put(compte.getCourriel(), composantesUtilisateur);
                    inventaires.put(courrielFournisseur, composantesFournisseur);
                    ComposanteUtil.ecrireComposantesDansFichier(inventaires,
                            "Application\\src\\main\\java\\Donnees\\Composantes.json");
                    System.out.println("Composante achetée avec succès.");
                    return;
                }
            }
            System.out.println("Erreur : Composante non trouvée ou déjà achetée.");
        } else {
            System.out.println("Erreur lors de la lecture des inventaires.");
        }
    }

    /**
     * Trouve un fournisseur et affiche ses informations.
     */

    private void trouverFournisseur() {
        Map<String, List<Composante>> inventaires = ComposanteUtil
                .lireComposantesDepuisFichier("Application\\src\\main\\java\\Donnees\\Composantes.json");
        if (inventaires != null) {
            Map<String, Set<ComposanteType>> fournisseursComposantes = new HashMap<>();

            for (Map.Entry<String, List<Composante>> entry : inventaires.entrySet()) {
                String courriel = entry.getKey();
                List<Composante> composantes = entry.getValue();
                Set<ComposanteType> types = composantes.stream()
                        .map(Composante::getType)
                        .collect(Collectors.toSet());
                fournisseursComposantes.put(courriel, types);
            }

            boolean retour = false;
            while (!retour) {
                System.out.println("Liste des fournisseurs :");
                List<String> fournisseurs = new ArrayList<>(fournisseursComposantes.keySet());
                for (int i = 0; i < fournisseurs.size(); i++) {
                    String courriel = fournisseurs.get(i);
                    Set<ComposanteType> types = fournisseursComposantes.get(courriel);
                    System.out.println((i + 1) + ". " + courriel + ", Types : " + types);
                }
                System.out.println((fournisseurs.size() + 1) + ". Retour");

                int choix = Integer
                        .parseInt(view.getDetail("Entrez le numéro du fournisseur pour voir ses informations ou "
                                + (fournisseurs.size() + 1) + " pour revenir au menu principal"));

                if (choix < 1 || choix > fournisseurs.size() + 1) {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                } else if (choix == fournisseurs.size() + 1) {
                    retour = true;
                } else {
                    String courrielFournisseur = fournisseurs.get(choix - 1);
                    afficherDetailsFournisseur(courrielFournisseur);
                }
            }
        } else {
            System.out.println("Aucun inventaire trouvé.");
        }
    }

    /**
     * Affiche les détails d'un fournisseur spécifique.
     * 
     * @param courriel le courriel du fournisseur.
     */

    private void afficherDetailsFournisseur(String courriel) {
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier("Application\\src\\main\\java\\Donnees\\Comptes.json");
        if (comptes != null) {
            for (Compte compte : comptes) {
                if (compte.getCourriel().equals(courriel) && compte instanceof Fournisseur) {
                    Fournisseur fournisseur = (Fournisseur) compte;
                    boolean retour = false;
                    while (!retour) {
                        System.out.println("Détails du fournisseur :");
                        System.out.println("Courriel : " + fournisseur.getCourriel());
                        System.out.println("Pseudo : " + fournisseur.getPseudo());
                        System.out.println("Téléphone : " + fournisseur.getTelephone());
                        System.out.println("1. Retour");

                        int choix = Integer.parseInt(view.getDetail("Entrez 1 pour revenir"));

                        if (choix == 1) {
                            retour = true;
                        } else {
                            System.out.println("Choix invalide. Veuillez réessayer.");
                        }
                    }
                    return;
                }
            }
            System.out.println("Fournisseur non trouvé.");
        } else {
            System.out.println("Erreur lors de la lecture des comptes.");
        }
    }

}
