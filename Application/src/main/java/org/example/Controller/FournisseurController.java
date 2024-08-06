package org.example.Controller;

import org.example.Model.Fournisseur;

public class FournisseurController {
    private Fournisseur fournisseur;

    public FournisseurController(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getCourriel() {
        return fournisseur.getCourriel();
    }

    public void setCourriel(String courriel) {
        fournisseur.setCourriel(courriel);
    }

    public String getPseudo() {
        return fournisseur.getPseudo();
    }

    public void setPseudo(String pseudo) {
        fournisseur.setPseudo(pseudo);
    }

    public String getMotDePasse() {
        return fournisseur.getMotDePasse();
    }

    public void setMotDePasse(String motDePasse) {
        fournisseur.setMotDePasse(motDePasse);
    }

    public String getTelephone() {
        return fournisseur.getTelephone();
    }

    public void setTelephone(String telephone) {
        fournisseur.setTelephone(telephone);
    }

    public Integer getCapaciteFabrication() {
        return fournisseur.getCapaciteFabrication();
    }

    public void setCapaciteFabrication(Integer capaciteFabrication) {
        fournisseur.setCapaciteFabrication(capaciteFabrication);
    }

    public void afficherDetailsFournisseur() {
        System.out.println("Courriel: " + fournisseur.getCourriel());
        System.out.println("Pseudo: " + fournisseur.getPseudo());
        System.out.println("Mot de Passe: " + fournisseur.getMotDePasse());
        System.out.println("Téléphone: " + fournisseur.getTelephone());
        System.out.println("Capacité de Fabrication: " + fournisseur.getCapaciteFabrication());
    }
}
