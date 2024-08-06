package org.example;

import org.example.Model.*;
import org.example.View.ConnexionMenuView;
import org.example.View.EmailView;
import org.example.View.MenuPrincipalView;
import org.example.Controller.*;

/**
 * Classe principale du programme Robotix.
 * Elle initialise les vues et les contrôleurs, puis démarre le programme.
 */
public class Main {

    /**
     * Méthode principale qui démarre l'application.
     * 
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        ConnexionMenuView connexionMenuView = new ConnexionMenuView();
        EmailView emailView = new EmailView();
        ConnexionMenuController connexionMenuController = new ConnexionMenuController(connexionMenuView, emailView);
        Compte compte = connexionMenuController.run();

        if (compte != null) {
            MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, compte);
            menuPrincipalController.run();
        } else {
            System.out.println("Connexion échouée ou inscription annulée.");
            System.out.println("Merci d\'avoir utilisé Robotix!");
        }
    }
}
