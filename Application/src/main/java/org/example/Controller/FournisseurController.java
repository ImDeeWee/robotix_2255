package org.example.Controller;

import org.example.Model.Fournisseur;

/**
 * Contrôleur pour la gestion des fournisseurs.
 */

public class FournisseurController {
    private Fournisseur fournisseur;

    /**
     * Constructeur de FournisseurController.
     * 
     * @param fournisseur le fournisseur géré par ce contrôleur.
     */

    public FournisseurController(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    /**
     * Obtient le courriel du fournisseur.
     * 
     * @return le courriel du fournisseur.
     */

    public String getCourriel() {
        return fournisseur.getCourriel();
    }

    /**
     * Définit le courriel du fournisseur.
     * 
     * @param courriel le nouveau courriel du fournisseur.
     */

    public void setCourriel(String courriel) {
        fournisseur.setCourriel(courriel);
    }

    /**
     * Obtient le pseudo du fournisseur.
     * 
     * @return le pseudo du fournisseur.
     */

    public String getPseudo() {
        return fournisseur.getPseudo();
    }

    /**
     * Définit le pseudo du fournisseur.
     * 
     * @param pseudo le nouveau pseudo du fournisseur.
     */

    public void setPseudo(String pseudo) {
        fournisseur.setPseudo(pseudo);
    }

    /**
     * Obtient le mot de passe du fournisseur.
     * 
     * @return le mot de passe du fournisseur.
     */

    public String getMotDePasse() {
        return fournisseur.getMotDePasse();
    }

    /**
     * Définit le mot de passe du fournisseur.
     * 
     * @param motDePasse le nouveau mot de passe du fournisseur.
     */

    public void setMotDePasse(String motDePasse) {
        fournisseur.setMotDePasse(motDePasse);
    }

    /**
     * Obtient le téléphone du fournisseur.
     * 
     * @return le téléphone du fournisseur.
     */

    public String getTelephone() {
        return fournisseur.getTelephone();
    }

    /**
     * Définit le téléphone du fournisseur.
     * 
     * @param telephone le nouveau téléphone du fournisseur.
     */

    public void setTelephone(String telephone) {
        fournisseur.setTelephone(telephone);
    }

    /**
     * Obtient la capacité de fabrication du fournisseur.
     * 
     * @return la capacité de fabrication du fournisseur.
     */

    public Integer getCapaciteFabrication() {
        return fournisseur.getCapaciteFabrication();
    }

    /**
     * Définit la capacité de fabrication du fournisseur.
     * 
     * @param capaciteFabrication la nouvelle capacité de fabrication du
     *                            fournisseur.
     */

    public void setCapaciteFabrication(Integer capaciteFabrication) {
        fournisseur.setCapaciteFabrication(capaciteFabrication);
    }

    /**
     * Affiche les détails du fournisseur.
     */

    public void afficherDetailsFournisseur() {
        System.out.println("Courriel: " + fournisseur.getCourriel());
        System.out.println("Pseudo: " + fournisseur.getPseudo());
        System.out.println("Mot de Passe: " + fournisseur.getMotDePasse());
        System.out.println("Téléphone: " + fournisseur.getTelephone());
        System.out.println("Capacité de Fabrication: " + fournisseur.getCapaciteFabrication());
    }
}
