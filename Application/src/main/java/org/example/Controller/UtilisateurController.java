package org.example.Controller;

import org.example.Model.Utilisateur;
import java.util.ArrayList;

/**
 * Contrôleur pour la gestion des utilisateurs.
 */
public class UtilisateurController {
    private Utilisateur utilisateur;

    /**
     * Constructeur de UtilisateurController.
     * 
     * @param utilisateur l'utilisateur géré par ce contrôleur.
     */
    public UtilisateurController(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Obtient le courriel de l'utilisateur.
     * 
     * @return le courriel de l'utilisateur.
     */
    public String getCourriel() {
        return utilisateur.getCourriel();
    }

    /**
     * Définit le courriel de l'utilisateur.
     * 
     * @param courriel le nouveau courriel de l'utilisateur.
     */
    public void setCourriel(String courriel) {
        utilisateur.setCourriel(courriel);
    }

    /**
     * Obtient le pseudo de l'utilisateur.
     * 
     * @return le pseudo de l'utilisateur.
     */
    public String getPseudo() {
        return utilisateur.getPseudo();
    }

    /**
     * Définit le pseudo de l'utilisateur.
     * 
     * @param pseudo le nouveau pseudo de l'utilisateur.
     */
    public void setPseudo(String pseudo) {
        utilisateur.setPseudo(pseudo);
    }

    /**
     * Obtient le mot de passe de l'utilisateur.
     * 
     * @return le mot de passe de l'utilisateur.
     */
    public String getMotDePasse() {
        return utilisateur.getMotDePasse();
    }

    /**
     * Définit le mot de passe de l'utilisateur.
     * 
     * @param motDePasse le nouveau mot de passe de l'utilisateur.
     */
    public void setMotDePasse(String motDePasse) {
        utilisateur.setMotDePasse(motDePasse);
    }

    /**
     * Obtient le téléphone de l'utilisateur.
     * 
     * @return le téléphone de l'utilisateur.
     */
    public String getTelephone() {
        return utilisateur.getTelephone();
    }

    /**
     * Définit le téléphone de l'utilisateur.
     * 
     * @param telephone le nouveau téléphone de l'utilisateur.
     */
    public void setTelephone(String telephone) {
        utilisateur.setTelephone(telephone);
    }

    /**
     * Obtient le nom de l'utilisateur.
     * 
     * @return le nom de l'utilisateur.
     */
    public String getNom() {
        return utilisateur.getNom();
    }

    /**
     * Définit le nom de l'utilisateur.
     * 
     * @param nom le nouveau nom de l'utilisateur.
     */
    public void setNom(String nom) {
        utilisateur.setNom(nom);
    }

    /**
     * Obtient le prénom de l'utilisateur.
     * 
     * @return le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return utilisateur.getPrenom();
    }

    /**
     * Définit le prénom de l'utilisateur.
     * 
     * @param prenom le nouveau prénom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        utilisateur.setPrenom(prenom);
    }

    /**
     * Obtient le nom de la compagnie de l'utilisateur.
     * 
     * @return le nom de la compagnie de l'utilisateur.
     */
    public String getNomDeCompagnie() {
        return utilisateur.getNomDeCompagnie();
    }

    /**
     * Définit le nom de la compagnie de l'utilisateur.
     * 
     * @param nomDeCompagnie le nouveau nom de la compagnie de l'utilisateur.
     */
    public void setNomDeCompagnie(String nomDeCompagnie) {
        utilisateur.setNomDeCompagnie(nomDeCompagnie);
    }

    /**
     * Obtient les intérêts de l'utilisateur.
     * 
     * @return les intérêts de l'utilisateur.
     */
    public ArrayList<String> getInterets() {
        return utilisateur.getInterets();
    }

    /**
     * Définit les intérêts de l'utilisateur.
     * 
     * @param interets les nouveaux intérêts de l'utilisateur.
     */
    public void setInterets(ArrayList<String> interets) {
        utilisateur.setInterets(interets);
    }

    /**
     * Ajoute un intérêt à l'utilisateur.
     * 
     * @param interet l'intérêt à ajouter.
     */
    public void addInteret(String interet) {
        utilisateur.addInteret(interet);
    }

    /**
     * Supprime un intérêt de l'utilisateur.
     * 
     * @param interet l'intérêt à supprimer.
     */
    public void removeInteret(String interet) {
        utilisateur.removeInteret(interet);
    }

    /**
     * Affiche les détails de l'utilisateur.
     */
    public void afficherDetailsUtilisateur() {
        System.out.println("Courriel: " + utilisateur.getCourriel());
        System.out.println("Pseudo: " + utilisateur.getPseudo());
        System.out.println("Mot de Passe: " + utilisateur.getMotDePasse());
        System.out.println("Téléphone: " + utilisateur.getTelephone());
        System.out.println("Nom: " + utilisateur.getNom());
        System.out.println("Prénom: " + utilisateur.getPrenom());
        System.out.println("Nom de Compagnie: " + utilisateur.getNomDeCompagnie());
        System.out.println("Intérêts: " + String.join(", ", utilisateur.getInterets()));
    }
}