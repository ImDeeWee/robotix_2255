package org.example.Controller;

import org.example.Model.Utilisateur;
import java.util.ArrayList;

public class UtilisateurController {
    private Utilisateur utilisateur;

    public UtilisateurController(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getCourriel() {
        return utilisateur.getCourriel();
    }

    public void setCourriel(String courriel) {
        utilisateur.setCourriel(courriel);
    }

    public String getPseudo() {
        return utilisateur.getPseudo();
    }

    public void setPseudo(String pseudo) {
        utilisateur.setPseudo(pseudo);
    }

    public String getMotDePasse() {
        return utilisateur.getMotDePasse();
    }

    public void setMotDePasse(String motDePasse) {
        utilisateur.setMotDePasse(motDePasse);
    }

    public String getTelephone() {
        return utilisateur.getTelephone();
    }

    public void setTelephone(String telephone) {
        utilisateur.setTelephone(telephone);
    }

    public String getNom() {
        return utilisateur.getNom();
    }

    public void setNom(String nom) {
        utilisateur.setNom(nom);
    }

    public String getPrenom() {
        return utilisateur.getPrenom();
    }

    public void setPrenom(String prenom) {
        utilisateur.setPrenom(prenom);
    }

    public String getNomDeCompagnie() {
        return utilisateur.getNomDeCompagnie();
    }

    public void setNomDeCompagnie(String nomDeCompagnie) {
        utilisateur.setNomDeCompagnie(nomDeCompagnie);
    }

    public ArrayList<String> getInterets() {
        return utilisateur.getInterets();
    }

    public void setInterets(ArrayList<String> interets) {
        utilisateur.setInterets(interets);
    }

    public void addInteret(String interet) {
        utilisateur.addInteret(interet);
    }

    public void removeInteret(String interet) {
        utilisateur.removeInteret(interet);
    }

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

