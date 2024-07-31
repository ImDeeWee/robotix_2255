
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void afficherMenu(Integer choix) {
        switch (choix) {
            case 0:
                System.out.println("Bienvenu dans Robotix! \nVeuillez choisir une option : \n[1] S'inscrire \n[2] Se connecter \n[3] Email");
                break;

            case 1:
                System.out.println("\nMENU PRINCIPAL \n---------------------");
                System.out.println("[1] Modifier son profil \n[2] Gestion tâches \n[3] Gestion d'activités \n[4] Enregistrer un robot \n[5] Acheter Composantes \n[6] Quitter Robotix");
                break;

            case 2:
                System.out.println("\nMENU FOURNISSEUR \n---------------------");
                System.out.println("[1] Modifier son profil \n[2] Gérer ses composantes \n[3] Quitter Robotix");
                break;
        }
    }

    public static void main(String[] args) {
        ArrayList<Composantes> inventaire = new ArrayList<>();
        ArrayList<Composantes> achats = new ArrayList<>();
        ArrayList<Robot> flotte = new ArrayList<>();

        CPU cpuTest = new CPU("AMD Ryzen 5", "5600X 6-Core Processor", 188.98, true);
        Composantes heliceTest = new Composantes();
        Composantes hautParleur = new Composantes();
    
        cpuTest.setNumeroDeSerie(1234567);
        heliceTest.setNom("Helice xd");
        heliceTest.setDescription("15 cm, couleur bleu");
        heliceTest.setPrix(32.95);
        heliceTest.setIsDisponible(true);
        heliceTest.setType(ComposanteType.HELICE);

        hautParleur.setNom("Haut parleur hd");
        hautParleur.setDescription("Haute définition");
        hautParleur.setPrix(17.38);
        hautParleur.setIsDisponible(true);
        hautParleur.setType(ComposanteType.HAUTPARLEUR);

        inventaire.add(cpuTest);
        inventaire.add(heliceTest);
        inventaire.add(hautParleur);


        Tache tacheTest = new Tache("Avancer de 5m et émettre un son de police");
        Action actionMouvement = new ActionMouvement("Avancer", 5, 0, 0, 0);
        Action actionSon = new ActionSon("Émettre un son", "Son de police");

        tacheTest.addAction(actionMouvement);
        tacheTest.addAction(actionSon);


        ArrayList<Tache> tachesDisponibles = new ArrayList<>();
        tachesDisponibles.add(tacheTest);


        ArrayList<Activite> activitesDisponibles = new ArrayList<>();

        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Activite activite1 = new Activite("Jeu éducatif", "Un jeu pour apprendre en s'amusant", sdf.parse("2024-07-01"), sdf.parse("2024-07-10"), 100);
            Activite activite2 = new Activite("Création artistique", "Créer des œuvres d'art avec des robots", sdf.parse("2024-07-05"), sdf.parse("2024-07-15"), 150);
            Activite activite3 = new Activite("Concours de robots", "Concourir pour le meilleur robot", sdf.parse("2024-07-10"), sdf.parse("2024-07-20"), 200);
            Activite activite4 = new Activite("Formation en programmation", "Apprendre à programmer des robots", sdf.parse("2024-07-15"), sdf.parse("2024-07-25"), 120);
            Activite activite5 = new Activite("Atelier de réparation", "Réparer et maintenir des robots", sdf.parse("2024-07-20"), sdf.parse("2024-07-30"), 80);

            activitesDisponibles.add(activite1);
            activitesDisponibles.add(activite2);
            activitesDisponibles.add(activite3);
            activitesDisponibles.add(activite4);
            activitesDisponibles.add(activite5);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ArbreCompte reseauSocial = new ArbreCompte();
        ArbreEmail arbreEmail = new ArbreEmail();
        InitialisationComptes initialisationComptes = new InitialisationComptes();
        reseauSocial = initialisationComptes.initialisationCompte(reseauSocial);
        int option;
        boolean emailAccess;
        String email;
        System.out.println("Initilisation des comptes de depart2:");
        reseauSocial.inorder();
        System.out.println("\n");


        Scanner scanner = new Scanner(System.in);
        Integer choixAccueil = null;


        while (choixAccueil == null || choixAccueil == 0 || (choixAccueil != 1 && choixAccueil != 2 && choixAccueil != 3)) {
            afficherMenu(0);
            try {
                choixAccueil = Integer.parseInt(scanner.nextLine());
                if (choixAccueil != 1 && choixAccueil != 2 && choixAccueil != 3) {
                    System.out.println("Option invalide : [1,2 ou 3].");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                choixAccueil = 0;
            }


            if (choixAccueil == 1) {

                Inscription newInscription = new Inscription();
                boolean optionIsInt = false;




                while (!optionIsInt) {

                    try {


                        System.out.println("Veuillez choisir le type de compte:\n1: Utilisateur\n2: Fournisseur");


                        option = scanner.nextInt();
                        scanner.nextLine();


                        if (option == 1) {
                            arbreEmail = newInscription.insciptionUtilisateur(reseauSocial, arbreEmail);
                            System.out.println("Votre compte a bien été créé \nVoici tous les courriels qui sont rentree dans le systeme");
                            arbreEmail.inorder();
                            System.out.println("\n");
                            optionIsInt = true;

                        } else if (option == 2) {
                            arbreEmail = newInscription.insciptionFournisseur(reseauSocial, arbreEmail);
                            System.out.println("Votre compte a bien été créé \nVoici tous les courriels qui sont rentree dans le systeme");
                            arbreEmail.inorder();
                            System.out.println("\n");
                            optionIsInt = true;
                        }
                        else{
                            System.out.println("L'option que vous venez de selectionner n'est pas disponible. Veuillez choisir l'option 1 ou 2!");
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Veuillez choisir une des 2 options presentees!");
                        scanner.nextLine();
                    }
                }


                choixAccueil = 0;
            }

            if (choixAccueil == 3) {
                emailAccess = true;
                while (emailAccess) {
                    System.out.print("Veuillez inscrire votre email ou \"EXIT\" pour revenir au menu principal: ");
                    email = scanner.next();

                    if (Objects.equals(email, "EXIT")) {
                        emailAccess = false;
                    } else if (!arbreEmail.isNodePresent(email)) {
                        System.out.println("L'email entree n'existe pas. Veuillez creer l'email a la suite de l'inscription d'un compte Robotix ou bien entrer votre email correctement.");
                    } else {
                        ArbreEmail.Email userEmail = arbreEmail.getEmail(email);
                        while (emailAccess) {
                            System.out.println("Rentrer votre mot de passe");
                            String password = scanner.next();

                            if (!Objects.equals(password, userEmail.getPassword())) {
                                System.out.println("Le mot de passe est incorrect. Veuillez reessayer!");
                            } else {
                                reseauSocial = arbreEmail.getInbox(userEmail, reseauSocial);
                                reseauSocial.inorder();
                                emailAccess = false;
                            }
                        }

                    }
                }
                choixAccueil = 0;
            }

            if (choixAccueil == 2) {
                ArbreCompte.Compte connectedAccount = null;
                emailAccess = true;


                while (emailAccess) {
                    System.out.print("Veuillez inscrire votre email associe avec votre compte Robotix: ");
                    email = scanner.next();

                   if (!reseauSocial.isEmailPresent(email)) {
                        System.out.println("L'email entree n'existe pas. Veuillez creer l'email a la suite de l'inscription d'un compte Robotix ou bien entrer votre email correctement.");
                    }
                   else {
                        ArbreCompte.Compte userCompte = reseauSocial.getCompteWEmail(email); // ICI
                        while (emailAccess) {
                            System.out.println(userCompte.getPassword());
                            System.out.println("Rentrer votre mot de passe");
                            String password = scanner.next();
                            scanner.nextLine();

                            if (!Objects.equals(password, userCompte.getPassword())) {
                                System.out.println("Le mot de passe est incorrect. Veuillez reessayer!");
                            } else {
                                System.out.println("Vous etes connecté a votre compte Robotix " + userCompte.getIdentifiant());
                                connectedAccount = userCompte;
                                emailAccess = false;
                            }
                        }
                   }
                }

                if (connectedAccount.accountType == TypeCompte.Fournisseur) {
                    boolean exitSupplierMenu = false;
                    while (!exitSupplierMenu) {
                        afficherMenu(2);
                        choixAccueil = null;

                        while (choixAccueil == null || choixAccueil < 1 || choixAccueil > 4) {
                            try {
                                choixAccueil = Integer.parseInt(scanner.nextLine());
                                if (choixAccueil < 1 || choixAccueil > 4) {
                                    System.out.println("Option invalide, veuillez entrer un nombre entre 1 et 4.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                            }
                        }

                        switch (choixAccueil) {
                            case 1:
                                boolean exitProfileMenu = false;
                                while (!exitProfileMenu) {
                                    System.out.println("\nVotre profil:");
                                    System.out.println("[1] Pseudo: " + connectedAccount.getIdentifiant());
                                    System.out.println("[2] Nom: " + connectedAccount.getNom());
                                    System.out.println("[3] Courriel: " + connectedAccount.getCourriel());
                                    System.out.println("[4] Téléphone: " + connectedAccount.getPhone());
                                    System.out.println("[5] Compagnie: " + connectedAccount.getCompagnie());
                                    System.out.println("[6] Mot de passe: " + connectedAccount.getPassword());
                                    System.out.println("[7] Capacité de fabrication: " + connectedAccount.getCapaciteFabrication());
                                    System.out.println("[8] Retour au menu principal");

                                    System.out.println("Choisissez le numéro de l'information que vous souhaitez modifier:");
                                    int choixModification = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (choixModification) {
                                        case 1:
                                            System.out.println("Entrez le nouveau pseudo:");
                                            String nouveauPseudo = scanner.nextLine();
                                            connectedAccount.setIdentifiant(nouveauPseudo);
                                            System.out.println("Pseudo mis à jour avec succès.");
                                            break;
                                        case 2:
                                            System.out.println("Entrez le nouveau nom:");
                                            String nouveauNom = scanner.nextLine();
                                            connectedAccount.setNom(nouveauNom);
                                            System.out.println("Nom mis à jour avec succès.");
                                            break;
                                        case 3:
                                            System.out.println("Entrez le nouveau courriel:");
                                            String nouveauCourriel = scanner.nextLine();
                                            connectedAccount.setCourriel(nouveauCourriel);
                                            System.out.println("Courriel mis à jour avec succès.");
                                            break;
                                        case 4:
                                            System.out.println("Entrez le nouveau numéro de téléphone:");
                                            Integer nouveauPhone = scanner.nextInt();
                                            scanner.nextLine();
                                            connectedAccount.setPhone(nouveauPhone);
                                            System.out.println("Numéro de téléphone mis à jour avec succès.");
                                            break;
                                        case 5:
                                            System.out.println("Entrez la nouvelle compagnie:");
                                            String nouvelleCompagnie = scanner.nextLine();
                                            connectedAccount.setCompagnie(nouvelleCompagnie);
                                            System.out.println("Compagnie mise à jour avec succès.");
                                            break;
                                        case 6:
                                            System.out.println("Entrez le nouveau mot de passe:");
                                            String nouveauMotDePasse = scanner.nextLine();
                                            connectedAccount.setPassword(nouveauMotDePasse);
                                            System.out.println("Mot de passe mis à jour avec succès.");
                                            break;
                                        case 7:
                                            System.out.println("Entrez la nouvelle capacité de fabrication:");
                                            Integer nouvelleCapacite = scanner.nextInt();
                                            scanner.nextLine();
                                            connectedAccount.setCapaciteFabrication(nouvelleCapacite);
                                            System.out.println("Capacité de fabrication mise à jour avec succès.");
                                            break;
                                        case 8:
                                            exitProfileMenu = true;
                                            break;
                                        default:
                                            System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            break;
                                    }
                                }
                                break;

                                case 2:
                                boolean exitComponentManagementMenu = false;
                                while (!exitComponentManagementMenu) {
                                    System.out.println("\nMENU GÉRER SES COMPOSANTES \n---------------------");
                                    System.out.println("[1] Voir les composantes dans l'inventaire");
                                    System.out.println("[2] Supprimer une composante de l'inventaire");
                                    System.out.println("[3] Ajouter une composante à l'inventaire");
                                    System.out.println("[4] Retour au menu principal");
                            
                                    int choixComponentManagement = scanner.nextInt();
                                    scanner.nextLine();
                            
                                    switch (choixComponentManagement) {
                                        case 1:
                                            if (inventaire.isEmpty()) {
                                                System.out.println("L'inventaire est vide.");
                                            } else {
                                                System.out.println("Composantes dans l'inventaire:");
                                                for (int i = 0; i < inventaire.size(); i++) {
                                                    Composantes composante = inventaire.get(i);
                                                    System.out.println("[" + (i + 1) + "] " + composante.getNom() + ": " + composante.getDescription());
                                                }
                                            }
                                            break;
                            
                                        case 2:
                                            if (inventaire.isEmpty()) {
                                                System.out.println("L'inventaire est vide, aucune composante à supprimer.");
                                            } else {
                                                System.out.println("Veuillez choisir une composante à supprimer:");
                                                for (int i = 0; i < inventaire.size(); i++) {
                                                    Composantes composante = inventaire.get(i);
                                                    System.out.println("[" + (i + 1) + "] " + composante.getNom() + ": " + composante.getDescription());
                                                }
                            
                                                int choixSuppression = scanner.nextInt();
                                                scanner.nextLine();
                            
                                                if (choixSuppression < 1 || choixSuppression > inventaire.size()) {
                                                    System.out.println("Option invalide.");
                                                } else {
                                                    Composantes composanteASupprimer = inventaire.get(choixSuppression - 1);
                                                    inventaire.remove(composanteASupprimer);
                                                    System.out.println("Composante supprimée: " + composanteASupprimer.getNom());
                                                }
                                            }
                                            break;
                            
                                        case 3:
                                            System.out.println("Ajouter une nouvelle composante à l'inventaire.");
                                            System.out.print("Nom: ");
                                            String nomComposante = scanner.nextLine();
                            
                                            System.out.print("Description: ");
                                            String descriptionComposante = scanner.nextLine();
                            
                                            System.out.print("Prix: ");
                                            double prixComposante = scanner.nextDouble();
                                            scanner.nextLine();
                            
                                            System.out.print("Type (ROUES, BRAS, HELICE, CAMERA, HAUTPARLEUR, MICRO, ECRAN): ");
                                            ComposanteType typeComposante = ComposanteType.valueOf(scanner.nextLine().toUpperCase());
                            
                                            System.out.print("Disponible (true/false): ");
                                            boolean isDisponible = scanner.nextBoolean();
                                            scanner.nextLine();
                            
                                            Composantes nouvelleComposante = new Composantes(nomComposante, descriptionComposante, prixComposante, typeComposante, isDisponible);
                                            inventaire.add(nouvelleComposante);
                                            System.out.println("Nouvelle composante ajoutée à l'inventaire: " + nomComposante);
                                            break;
                            
                                        case 4:
                                            exitComponentManagementMenu = true;
                                            break;
                            
                                        default:
                                            System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            break;
                                    }
                                }
                                break;
                            
                            case 3:
                                System.out.println("Vous êtes déconnecté. Merci d'avoir utilisé Robotix!");
                                exitSupplierMenu = true;
                                System.exit(0);
                        }
                    }
                } 
                else {
                    boolean exitMainMenu = false;
                    while (!exitMainMenu) {
                        afficherMenu(1);
                        
                        choixAccueil = null;
                        
                        while (choixAccueil == null || choixAccueil < 1 || choixAccueil > 6) {
                            try {
                                choixAccueil = Integer.parseInt(scanner.nextLine());
                                if (choixAccueil < 1 || choixAccueil > 6) {
                                    System.out.println("Option invalide, veuillez entrer un nombre entre 1 et 6.");
                                    choixAccueil = null; 
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                                choixAccueil = null;
                            }
                        }

                        switch (choixAccueil) {
                            case 1:
                                boolean exitProfileMenu = false;
                                while (!exitProfileMenu) {
                                    System.out.println("\nVotre profil:");
                                    System.out.println("[1] Pseudo: " + connectedAccount.getIdentifiant());
                                    System.out.println("[2] Nom: " + connectedAccount.getNom());
                                    System.out.println("[3] Prénom: " + connectedAccount.getPrenom());
                                    System.out.println("[4] Courriel: " + connectedAccount.getCourriel());
                                    System.out.println("[5] Téléphone: " + connectedAccount.getPhone());
                                    System.out.println("[6] Compagnie: " + connectedAccount.getCompagnie());
                                    System.out.println("[7] Mot de passe: " + connectedAccount.getPassword());
                                    System.out.println("[8] Intérêts: " + connectedAccount.getInterets());
                                    System.out.println("[9] Followers: " + connectedAccount.getFollowers().size());
                                    System.out.println("[10] Following: " + connectedAccount.getFollowing().size());
                                    System.out.println("[11] Retour au menu principal");

                                    System.out.println("Choisissez le numéro de l'information que vous souhaitez modifier:");
                                    int choixModification = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (choixModification) {
                                        case 1:
                                            System.out.println("Entrez le nouveau pseudo:");
                                            String nouveauPseudo = scanner.nextLine();
                                            connectedAccount.setIdentifiant(nouveauPseudo);
                                            System.out.println("Pseudo mis à jour avec succès.");
                                            break;
                                        case 2:
                                            System.out.println("Entrez le nouveau nom:");
                                            String nouveauNom = scanner.nextLine();
                                            connectedAccount.setNom(nouveauNom);
                                            System.out.println("Nom mis à jour avec succès.");
                                            break;
                                        case 3:
                                            System.out.println("Entrez le nouveau prénom:");
                                            String nouveauPrenom = scanner.nextLine();
                                            connectedAccount.setPrenom(nouveauPrenom);
                                            System.out.println("Prénom mis à jour avec succès.");
                                            break;
                                        case 4:
                                            System.out.println("Entrez le nouveau courriel:");
                                            String nouveauCourriel = scanner.nextLine();
                                            connectedAccount.setCourriel(nouveauCourriel);
                                            System.out.println("Courriel mis à jour avec succès.");
                                            break;
                                        case 5:
                                            System.out.println("Entrez le nouveau numéro de téléphone:");
                                            Integer nouveauPhone = scanner.nextInt();
                                            scanner.nextLine();
                                            connectedAccount.setPhone(nouveauPhone);
                                            System.out.println("Numéro de téléphone mis à jour avec succès.");
                                            break;
                                        case 6:
                                            System.out.println("Entrez la nouvelle compagnie:");
                                            String nouvelleCompagnie = scanner.nextLine();
                                            connectedAccount.setCompagnie(nouvelleCompagnie);
                                            System.out.println("Compagnie mise à jour avec succès.");
                                            break;
                                        case 7:
                                            System.out.println("Entrez le nouveau mot de passe:");
                                            String nouveauMotDePasse = scanner.nextLine();
                                            connectedAccount.setPassword(nouveauMotDePasse);
                                            System.out.println("Mot de passe mis à jour avec succès.");
                                            break;
                                        case 8:
                                            boolean exitInterestsMenu = false;
                                            while (!exitInterestsMenu) {
                                                System.out.println("\nVos intérêts actuels: " + connectedAccount.getInterets());
                                                System.out.println("[1] Ajouter un intérêt");
                                                System.out.println("[2] Supprimer un intérêt");
                                                System.out.println("[3] Retour au menu profil");

                                                int choixInteret = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (choixInteret) {
                                                    case 1:
                                                        System.out.println("Entrez le nouvel intérêt:");
                                                        String nouvelInteret = scanner.nextLine();
                                                        connectedAccount.addInteret(nouvelInteret);
                                                        System.out.println("Intérêt ajouté avec succès.");
                                                        break;
                                                    case 2:
                                                        System.out.println("Entrez l'intérêt à supprimer:");
                                                        String interetASupprimer = scanner.nextLine();
                                                        connectedAccount.getInterets().remove(interetASupprimer);
                                                        System.out.println("Intérêt supprimé avec succès.");
                                                        break;
                                                    case 3:
                                                        exitInterestsMenu = true;
                                                        break;
                                                    default:
                                                        System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                                        break;
                                                }
                                            }
                                            break;
                                        case 9:
                                            System.out.println("Liste des followers:");
                                            for (ArbreCompte.Compte follower : connectedAccount.getFollowers()) {
                                                System.out.println("- " + follower.getIdentifiant());
                                            }
                                            break;
                                        case 10:
                                            boolean exitFollowingMenu = false;
                                            while (!exitFollowingMenu) {
                                                System.out.println("\nGestion des following:");
                                                System.out.println("[1] Voir les following");
                                                System.out.println("[2] Suivre un utilisateur");
                                                System.out.println("[3] Arrêter de suivre un utilisateur");
                                                System.out.println("[4] Retour au menu profil");

                                                int choixFollowing = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (choixFollowing) {
                                                    case 1:
                                                        System.out.println("Liste des following:");
                                                        for (ArbreCompte.Compte following : connectedAccount.getFollowing()) {
                                                            System.out.println("- " + following.getIdentifiant());
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Entrez le pseudo de l'utilisateur à suivre:");
                                                        String pseudoSuivre = scanner.nextLine();
                                                        ArbreCompte.Compte utilisateurASuivre = (ArbreCompte.Compte) reseauSocial.getNode(pseudoSuivre);
                                                        if (utilisateurASuivre != null && !connectedAccount.getFollowing().contains(utilisateurASuivre)) {
                                                            connectedAccount.addFollowing(utilisateurASuivre);
                                                            utilisateurASuivre.addFollower(connectedAccount);
                                                            System.out.println("Vous suivez maintenant " + utilisateurASuivre.getIdentifiant());
                                                        } else {
                                                            System.out.println("Utilisateur introuvable ou déjà suivi.");
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Entrez le pseudo de l'utilisateur à arrêter de suivre:");
                                                        String pseudoArreter = scanner.nextLine();
                                                        ArbreCompte.Compte utilisateurAArreter = (ArbreCompte.Compte) reseauSocial.getNode(pseudoArreter);
                                                        if (utilisateurAArreter != null && connectedAccount.getFollowing().contains(utilisateurAArreter)) {
                                                            connectedAccount.removeFollowing(utilisateurAArreter);
                                                            utilisateurAArreter.removeFollower(connectedAccount);
                                                            System.out.println("Vous ne suivez plus " + utilisateurAArreter.getIdentifiant());
                                                        } else {
                                                            System.out.println("Utilisateur introuvable ou pas suivi.");
                                                        }
                                                        break;
                                                    case 4:
                                                        exitFollowingMenu = true;
                                                        break;
                                                    default:
                                                        System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                                        break;
                                                }
                                            }
                                            break;

                                        case 11:
                                            exitProfileMenu = true;
                                            break;
                                        default:
                                            System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            break;
                                    }
                                }
                                break;
                            
                                case 2:
                                    boolean exitTaskMenu = false;
                                    while (!exitTaskMenu) {
                                        System.out.println("\nMENU GESTION TÂCHES \n---------------------");
                                        System.out.println("[1] Assigner une tâche à un robot");
                                        System.out.println("[2] Créer et assigner une nouvelle tâche");
                                        System.out.println("[3] Consulter les tâches existantes");
                                        System.out.println("[4] Retour au menu principal");

                                        int choixTask = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (choixTask) {
                                            case 1:
                                                System.out.println("Veuillez entrer le numéro de série du robot:");
                                                int numeroDeSerie = scanner.nextInt();
                                                scanner.nextLine();

                                                Robot robot = null;
                                                for (Robot r : flotte) {
                                                    if (r.getCpu().getNumeroDeSerie() == numeroDeSerie) {
                                                        robot = r;
                                                        break;
                                                    }
                                                }

                                                if (robot == null) {
                                                    System.out.println("Robot introuvable.");
                                                } else {
                                                    System.out.println("Veuillez choisir une tâche à assigner:");
                                                    for (int i = 0; i < tachesDisponibles.size(); i++) {
                                                        System.out.println("[" + (i + 1) + "] " + tachesDisponibles.get(i).getDescription());
                                                    }

                                                    int choixTache = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if (choixTache < 1 || choixTache > tachesDisponibles.size()) {
                                                        System.out.println("Option invalide.");
                                                    } else {
                                                        Tache tache = tachesDisponibles.get(choixTache - 1);
                                                        boolean peutBouger = robot.hasComponent(ComposanteType.ROUES) || robot.hasComponent(ComposanteType.HELICE);
                                                        boolean peutEmettreSon = robot.hasComponent(ComposanteType.HAUTPARLEUR);

                                                        boolean tacheValide = true;
                                                        for (Action action : tache.getActions()) {
                                                            if (action instanceof ActionMouvement && !peutBouger) {
                                                                tacheValide = false;
                                                                System.out.println("Le robot ne peut pas bouger car il n'a pas de roues ou d'hélice.");
                                                                break;
                                                            }
                                                            if (action instanceof ActionSon && !peutEmettreSon) {
                                                                tacheValide = false;
                                                                System.out.println("Le robot ne peut pas émettre de son car il n'a pas de haut-parleur.");
                                                                break;
                                                            }
                                                        }

                                                        if (tacheValide) {
                                                            robot.addTache(tache);
                                                            System.out.println("Tâche assignée au robot.");
                                                        }
                                                    }
                                                }
                                                break;

                                            case 2:
                                                System.out.println("Veuillez entrer la description de la nouvelle tâche:");
                                                String description = scanner.nextLine();

                                                Tache nouvelleTache = new Tache(description);

                                                boolean ajouterAction = true;
                                                while (ajouterAction) {
                                                    System.out.println("Ajouter une action à la tâche:");
                                                    System.out.println("[1] Mouvement");
                                                    System.out.println("[2] Émettre un son");
                                                    System.out.println("[3] Terminer l'ajout d'actions");

                                                    int choixAction = scanner.nextInt();
                                                    scanner.nextLine();

                                                    switch (choixAction) {
                                                        case 1:
                                                            System.out.println("Veuillez entrer la distance en mètres:");
                                                            int distance = scanner.nextInt();
                                                            scanner.nextLine();

                                                            ActionMouvement actionMouvementNew = new ActionMouvement("Mouvement", distance, 0, 0, 0);
                                                            nouvelleTache.addAction(actionMouvementNew);
                                                            break;

                                                        case 2:
                                                            System.out.println("Veuillez entrer la description du son:");
                                                            String descriptionSon = scanner.nextLine();

                                                            ActionSon actionSonNew = new ActionSon("Émettre un son", descriptionSon);
                                                            nouvelleTache.addAction(actionSonNew);
                                                            break;

                                                        case 3:
                                                            ajouterAction = false;
                                                            break;

                                                        default:
                                                            System.out.println("Option invalide.");
                                                    }
                                                }

                                                tachesDisponibles.add(nouvelleTache);

                                                System.out.println("Nouvelle tâche créée. Veuillez entrer le numéro de série du robot à assigner:");
                                                numeroDeSerie = scanner.nextInt();
                                                scanner.nextLine();

                                                robot = null;
                                                for (Robot r : flotte) {
                                                    if (r.getCpu().getNumeroDeSerie() == numeroDeSerie) {
                                                        robot = r;
                                                        break;
                                                    }
                                                }

                                                if (robot == null) {
                                                    System.out.println("Robot introuvable.");
                                                } else {
                                                    boolean peutBouger = robot.hasComponent(ComposanteType.ROUES) || robot.hasComponent(ComposanteType.HELICE);
                                                    boolean peutEmettreSon = robot.hasComponent(ComposanteType.HAUTPARLEUR);

                                                    boolean tacheValide = true;
                                                    for (Action action : nouvelleTache.getActions()) {
                                                        if (action instanceof ActionMouvement && !peutBouger) {
                                                            tacheValide = false;
                                                            System.out.println("Le robot ne peut pas bouger car il n'a pas de roues ou d'hélice.");
                                                            break;
                                                        }
                                                        if (action instanceof ActionSon && !peutEmettreSon) {
                                                            tacheValide = false;
                                                            System.out.println("Le robot ne peut pas émettre de son car il n'a pas de haut-parleur.");
                                                            break;
                                                        }
                                                    }

                                                    if (tacheValide) {
                                                        robot.addTache(nouvelleTache);
                                                        System.out.println("Nouvelle tâche assignée au robot.");
                                                    }
                                                }
                                                break;

                                            case 3:
                                                System.out.println("Liste des tâches existantes:");
                                                for (int i = 0; i < tachesDisponibles.size(); i++) {
                                                    System.out.println("[" + (i + 1) + "] " + tachesDisponibles.get(i).getDescription());
                                                }
                                                System.out.println("Liste des tâches assignées aux robots:");
                                                for (Robot r : flotte) {
                                                    System.out.println("Robot: " + r.getNom() + " (Numéro de série: " + r.getCpu().getNumeroDeSerie() + ")");
                                                    for (Tache t : r.getTaches()) {
                                                        System.out.println(" - " + t.getDescription());
                                                    }
                                                }
                                                break;

                                            case 4:
                                                exitTaskMenu = true;
                                                break;

                                            default:
                                                System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                                break;
                                        }
                                    }
                                    break;

                                    case 3:
                                    boolean exitActivityMenu = false;
                                    while (!exitActivityMenu) {
                                        System.out.println("\nMENU GESTION ACTIVITÉS \n---------------------");
                                        System.out.println("[1] Consulter les activités existantes et assignées à quels robots");
                                        System.out.println("[2] Créer une nouvelle activité");
                                        System.out.println("[3] Assigner une activité à un robot");
                                        System.out.println("[4] Retour au menu principal");
                                
                                        int choixActivity = scanner.nextInt();
                                        scanner.nextLine();
                                
                                        switch (choixActivity) {
                                            case 1:
                                                System.out.println("Liste des activités existantes:");
                                                for (Activite activite : activitesDisponibles) {
                                                    System.out.println("Activité: " + activite.getNom() + " - " + activite.getDescription());
                                                    for (Robot r : flotte) {
                                                        if (r.getActivites().contains(activite)) {
                                                            System.out.println(" - Assignée au robot: " + r.getNom());
                                                        }
                                                    }
                                                }
                                                break;
                                
                                            case 2:
                                                System.out.println("Veuillez entrer le nom de la nouvelle activité:");
                                                String nomActivite = scanner.nextLine();
                                                System.out.println("Veuillez entrer la description de la nouvelle activité:");
                                                String descriptionActivite = scanner.nextLine();
                                                System.out.println("Veuillez entrer la date de début (yyyy-MM-dd):");
                                                Date startDate = null;
                                                try {
                                                    startDate = sdf.parse(scanner.nextLine());
                                                } catch (Exception e) {
                                                    System.out.println("Format de date invalide.");
                                                    break;
                                                }
                                                System.out.println("Veuillez entrer la date de fin (yyyy-MM-dd):");
                                                Date endDate = null;
                                                try {
                                                    endDate = sdf.parse(scanner.nextLine());
                                                } catch (Exception e) {
                                                    System.out.println("Format de date invalide.");
                                                    break;
                                                }
                                                System.out.println("Veuillez entrer le nombre de points:");
                                                int points = scanner.nextInt();
                                                scanner.nextLine();
                                
                                                Activite nouvelleActivite = new Activite(nomActivite, descriptionActivite, startDate, endDate, points);
                                                activitesDisponibles.add(nouvelleActivite);
                                
                                                System.out.println("Nouvelle activité créée.");
                                                break;
                                
                                            case 3:
                                                System.out.println("Veuillez entrer le numéro de série du robot:");
                                                int numeroDeSerie = scanner.nextInt();
                                                scanner.nextLine();
                                
                                                Robot robot = null;
                                                for (Robot r : flotte) {
                                                    if (r.getnumeroDeSerie() == numeroDeSerie) {
                                                        robot = r;
                                                        break;
                                                    }
                                                }
                                
                                                if (robot == null) {
                                                    System.out.println("Robot introuvable.");
                                                } else {
                                                    System.out.println("Veuillez choisir une activité à assigner:");
                                                    for (int i = 0; i < activitesDisponibles.size(); i++) {
                                                        System.out.println("[" + (i + 1) + "] " + activitesDisponibles.get(i).getNom());
                                                    }
                                
                                                    int choixActivite = scanner.nextInt();
                                                    scanner.nextLine();
                                
                                                    if (choixActivite < 1 || choixActivite > activitesDisponibles.size()) {
                                                        System.out.println("Option invalide.");
                                                    } else {
                                                        Activite activite = activitesDisponibles.get(choixActivite - 1);
                                                        robot.addActivite(activite);
                                                        System.out.println("Activité assignée au robot.");
                                                    }
                                                }
                                                break;
                                
                                            case 4:
                                                exitActivityMenu = true;
                                                break;
                                
                                            default:
                                                System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                                break;
                                        }
                                    }
                                    break;
                                


                                

                            case 4:
                                if (achats.isEmpty()) {
                                    System.out.println("Vous n'avez aucune pièce dans votre inventaire, impossible d'enregistrer un robot.");
                                } else {
                                    boolean hasCPU = false;
                                    boolean hasOtherComponent = false;

                                    for (Composantes composante : achats) {
                                        if (composante instanceof CPU) {
                                            hasCPU = true;
                                        } else {
                                            hasOtherComponent = true;
                                        }
                                    }

                                    if (!hasCPU) {
                                        System.out.println("Vous avez besoin d'un CPU pour enregistrer un robot.");
                                    } else if (!hasOtherComponent) {
                                        System.out.println("Il vous faut une autre pièce que le CPU pour enregistrer un robot.");
                                    } else {

                                        CPU selectedCPU = null;
                                        while (selectedCPU == null) {
                                            System.out.println("Veuillez sélectionner un CPU parmi les pièces suivantes :");
                                            int cpuIndex = 1;
                                            for (int i = 0; i < achats.size(); i++) {
                                                if (achats.get(i) instanceof CPU) {
                                                    System.out.println("[" + cpuIndex + "] " + achats.get(i).getNom());
                                                    cpuIndex++;
                                                }
                                            }
                                            int choixCPU = scanner.nextInt();
                                            scanner.nextLine();

                                            int actualCPUIndex = choixCPU - 1;
                                            cpuIndex = 0;
                                            for (int i = 0; i < achats.size(); i++) {
                                                if (achats.get(i) instanceof CPU) {
                                                    if (cpuIndex == actualCPUIndex) {
                                                        selectedCPU = (CPU) achats.get(i);
                                                        break;
                                                    }
                                                    cpuIndex++;
                                                }
                                            }

                                            if (selectedCPU == null) {
                                                System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            }
                                        }


                                        ArrayList<Composantes> selectedComponents = new ArrayList<>();
                                        for (int i = 0; i < achats.size(); i++) {
                                            if (!(achats.get(i) instanceof CPU)) {
                                                System.out.println("[" + (i + 1) + "] " + achats.get(i).getNom());
                                            }
                                        }

                                        while (true) {
                                            System.out.println("Entrez le numéro de la composante à ajouter au robot (entrez 0 pour terminer):");
                                            int choixComposante = scanner.nextInt();
                                            scanner.nextLine();

                                            if (choixComposante == 0) {
                                                break;
                                            } else if (choixComposante > 0 && choixComposante <= achats.size() && !(achats.get(choixComposante - 1) instanceof CPU)) {
                                                selectedComponents.add(achats.get(choixComposante - 1));
                                            } else {
                                                System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            }
                                        }


                                        System.out.println("Entrez le nom du robot:");
                                        String robotNom = scanner.nextLine();

                                        System.out.println("Entrez le type du robot:");
                                        String robotType = scanner.nextLine();


                                        Robot robot = new Robot(selectedCPU, robotNom, robotType);
                                        for (Composantes composante : selectedComponents) {
                                            robot.addComposante(composante);
                                        }

                                        System.out.println("\nRobot enregistré avec succès!\n");
                                        System.out.println("Nom: " + robot.getNom());
                                        System.out.println("Type: " + robot.getType());
                                        System.out.println("CPU: " + (robot.getCpu()).getNom());
                                        System.out.println("Numéro de série: " + robot.getCpu().getNumeroDeSerie());
                                        System.out.println("Composantes:");
                                        for (Composantes composante : robot.getComposantesRobot()) {
                                            System.out.println("- " + composante.getNom());
                                        }


                                        achats.remove(selectedCPU);
                                        achats.removeAll(selectedComponents);
                                        flotte.add(robot);
                                    }
                                }
                                break;

                            case 5:
                                boolean exitComponentsMenu = false;
                                while (!exitComponentsMenu) {
                                    if (inventaire.isEmpty()) {
                                        System.out.println("\nAucune composante disponible.\n");
                                        exitComponentsMenu = true;
                                        break;
                                    }

                                    System.out.println("Voici les pièces disponibles, séléctionnez une pièce pour plus de détails: ");
                                    for (int i = 0; i < inventaire.size(); i++) {
                                        System.out.println("[" + (i + 1) + "] " + inventaire.get(i).getNom());
                                    }
                                    System.out.println("[" + (inventaire.size() + 1) + "] Retour au menu principal");

                                    choixAccueil = null;

                                    while (choixAccueil == null || choixAccueil < 1 || choixAccueil > inventaire.size() + 1) {
                                        try {
                                            choixAccueil = Integer.parseInt(scanner.nextLine());
                                            if (choixAccueil < 1 || choixAccueil > inventaire.size() + 1) {
                                                System.out.println("Option invalide, veuillez entrer un nombre valide.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Entrée invalide, veuillez entrer un nombre.");
                                        }
                                    }

                                    if (choixAccueil == inventaire.size() + 1) {
                                        exitComponentsMenu = true;
                                    } else {
                                        Composantes composante = inventaire.get(choixAccueil - 1);
                                        System.out.println("\nDétails: ");
                                        System.out.println("Nom: " + composante.getNom());
                                        System.out.println("Description: " + composante.getDescription());
                                        System.out.println("Prix: " + composante.getPrix());
                                        System.out.println("Disponible: " + composante.getIsDisponible());
                                        System.out.println("Type: " + composante.getType());

                                        System.out.println("\nVoulez-vous confirmer l'achat?\n[1] CONFIRMER\n[2] ANNULER");

                                        choixAccueil = null;

                                        while (choixAccueil == null || (choixAccueil != 1 && choixAccueil != 2)) {
                                            try {
                                                choixAccueil = Integer.parseInt(scanner.nextLine());
                                                if (choixAccueil != 1 && choixAccueil != 2) {
                                                    System.out.println("Option invalide, veuillez entrer 1 ou 2.");
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                                            }
                                        }

                                        if (choixAccueil == 1) {
                                            achats.add(composante);
                                            inventaire.remove(composante);
                                            System.out.println("Achat confirmé.");
                                        } else {
                                            System.out.println("Achat annulé.");
                                        }
                                    }
                                }
                                break;

                            case 6:
                                System.out.println("Vous êtes déconnecté. Merci d'avoir utilisé Robotix!");
                                exitMainMenu = true;
                                System.exit(0);
                        }
                    }
                }
            }

        }

        
        scanner.close();  
    }
    
}
