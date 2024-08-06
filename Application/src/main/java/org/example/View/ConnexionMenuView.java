package org.example.View;

import java.util.Scanner;

/**
 * Classe de vue pour le menu de connexion et d'inscription.
 */

public class ConnexionMenuView {
    private Scanner scanner;

    /**
     * Constructeur de ConnexionMenuView.
     */

    public ConnexionMenuView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu de connexion.
     *
     * @return Le choix de l'utilisateur.
     */

    public int AfficherConnexionMenu() {
        System.out.println("Bienvenue sur Robotix");
        System.out.println("1. Connexion");
        System.out.println("2. S'inscrire");
        System.out.println("3. Gestion des courriels");
        System.out.println("4. Quitter");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Affiche le menu d'inscription.
     *
     * @return Le choix de l'utilisateur.
     */

    public int AfficherInscriptionMenu() {
        System.out.println("");
        System.out.println("Inscription");
        System.out.println("1. S'inscrire comme Utilisateur");
        System.out.println("2. S'inscrire comme Fournisseur");
        System.out.println("3. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Obtient les détails de connexion de l'utilisateur.
     *
     * @return Un tableau contenant le courriel et le mot de passe, ou null si
     *         l'utilisateur choisit de retourner au menu principal.
     */

    public String[] getConnexionDetails() {
        while (true) {
            System.out.println("");
            System.out.println("1. Entrez les détails de connexion");
            System.out.println("2. Retour au menu principal");
            System.out.print("Entrez votre choix: ");
            String choix = scanner.next();

            if (choix.equals("2")) {
                return null;
            } else if (choix.equals("1")) {
                System.out.println("");
                System.out.print("Entrez votre courriel: ");
                String courriel = scanner.next();
                System.out.print("Entrez votre mot de passe: ");
                String motDePasse = scanner.next();
                return new String[] { courriel, motDePasse };
            } else {
                System.out.println("Entrée invalide. Veuillez entrer [1 ou 2]");
            }
        }
    }

    /**
     * Obtient les détails d'inscription pour un fournisseur.
     *
     * @return Un tableau contenant les détails d'inscription pour un fournisseur.
     */

    public String[] getInscriptionDetailsFournisseur() {
        System.out.println("");
        System.out.print("Entrez votre courriel: ");
        String courriel = scanner.next();
        System.out.print("Choisissez votre pseudo: ");
        String pseudo = scanner.next();
        System.out.print("Choisissez un mot de passe: ");
        String motDePasse = scanner.next();
        System.out.print("Entrez votre numéro de téléphone: ");
        String telephone = scanner.next();
        System.out.print("Entrez votre capacité de fabrication: ");
        Integer capaciteDeFabrication = scanner.nextInt();
        return new String[] { courriel, pseudo, motDePasse, telephone, String.valueOf(capaciteDeFabrication) };
    }

    /**
     * Obtient les détails d'inscription pour un utilisateur.
     *
     * @return Un tableau contenant les détails d'inscription pour un utilisateur.
     */

    public String[] getInscriptionDetailsUtilisateur() {
        System.out.println("");
        System.out.print("Entrez votre courriel: ");
        String courriel = scanner.next();
        System.out.print("Choisissez votre pseudo: ");
        String pseudo = scanner.next();
        System.out.print("Choisissez un mot de passe: ");
        String motDePasse = scanner.next();
        System.out.print("Entrez votre numéro de téléphone: ");
        String telephone = scanner.next();
        System.out.print("Entrez votre nom: ");
        String nom = scanner.next();
        System.out.print("Entrez votre prénom: ");
        String prenom = scanner.next();
        System.out.print("Entrez votre nom de compagnie (optionnel): ");
        String nomDeCompagnie = scanner.next();

        System.out.print("Entrez vos intérêts séparés par des virgules: ");
        String interets = scanner.next();

        return new String[] { courriel, pseudo, motDePasse, telephone, nom, prenom, nomDeCompagnie, interets };
    }

    /**
     * Affiche un message d'invite et retourne l'entrée de l'utilisateur.
     *
     * @param prompt Le message d'invite pour l'utilisateur.
     * @return L'entrée de l'utilisateur.
     */

    public String getDetail(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
