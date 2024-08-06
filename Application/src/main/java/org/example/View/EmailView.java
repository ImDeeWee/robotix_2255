package org.example.View;

import java.util.Scanner;

/**
 * Classe de vue pour la gestion des courriels.
 */

public class EmailView {
    private Scanner scanner;

    /**
     * Constructeur de EmailView.
     */

    public EmailView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu de gestion des courriels.
     *
     * @return Le choix de l'utilisateur.
     */

    public int afficherMenuGestionCourriels() {
        System.out.println("");
        System.out.println("Gestion des courriels");
        System.out.println("1. Confirmer inscription");
        System.out.println("2. Retour au menu principal");
        System.out.print("Entrez votre choix: ");
        return scanner.nextInt();
    }

    /**
     * Obtient les détails pour la confirmation d'inscription.
     *
     * @return Un tableau contenant le courriel et le mot de passe.
     */

    public String[] getConfirmationDetails() {
        System.out.println("");
        System.out.print("Entrez votre courriel: ");
        String courriel = scanner.next();
        System.out.print("Entrez votre mot de passe: ");
        String motDePasse = scanner.next();
        return new String[] { courriel, motDePasse };
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

    /**
     * Obtient les détails du courriel.
     *
     * @return Un tableau contenant le courriel et le mot de passe.
     */

    public String[] getEmailDetails() {
        System.out.println("");
        System.out.print("Entrez votre courriel: ");
        String courriel = scanner.next();
        System.out.print("Entrez votre mot de passe: ");
        String motDePasse = scanner.next();
        return new String[] { courriel, motDePasse };
    }

}
