package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Cette classe constitue les Emails qui sont utilisés pour confirmer
 * l'inscription des comptes.
 * 
 * @see la Classe Compte
 */
public class Email {
    private String type;
    private String courriel;
    private String pseudo;
    private String motDePasse;
    private String telephone;
    private String nom;
    private String prenom;
    private String nomDeCompagnie;
    private ArrayList<String> interets;
    private boolean confirmed;
    private int capaciteFabrication;

    /**
     * Constructeur de nouvelle Email.
     * 
     * @param type                le type de compte à confirmer l'inscription.
     * @param courriel            le courriel de l'email.
     * @param pseudo              le pseudo du compte à confirmer l'inscription.
     * @param motDePasse          le mot de passe de l'email et du compte à
     *                            confirmer l'inscription.
     * @param telephone           le numéro de téléphone du compte à confirmer
     *                            l'inscription.
     * @param nom                 le nom du compte à confirmer l'inscription.
     * @param prenom              le prénom du compte à confirmer l'inscription.
     * @param nomDeCompagnie      le nom de compagnie du compte à confirmer
     *                            l'inscription.
     * @param interets            la liste d'intérêts du compte à confirmer
     *                            l'inscription.
     * @param confirmed           vrai si l'inscription du compte est déjà
     *                            confirmer, faux sinon.
     * @param capaciteFabrication la capacité de fabrication du compte à confirmer
     *                            l'inscription.
     */
    public Email(@JsonProperty("type") String type,
            @JsonProperty("courriel") String courriel,
            @JsonProperty("pseudo") String pseudo,
            @JsonProperty("motDePasse") String motDePasse,
            @JsonProperty("telephone") String telephone,
            @JsonProperty("nom") String nom,
            @JsonProperty("prenom") String prenom,
            @JsonProperty("nomDeCompagnie") String nomDeCompagnie,
            @JsonProperty("interets") ArrayList<String> interets,
            @JsonProperty("confirmed") boolean confirmed,
            @JsonProperty("capaciteFabrication") int capaciteFabrication) {
        this.type = type;
        this.courriel = courriel;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.nomDeCompagnie = (nomDeCompagnie != null) ? nomDeCompagnie : "";
        this.interets = (interets != null) ? interets : new ArrayList<>();
        this.confirmed = confirmed;
        this.capaciteFabrication = capaciteFabrication;
    }

    // Getters et setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomDeCompagnie() {
        return nomDeCompagnie;
    }

    public void setNomDeCompagnie(String nomDeCompagnie) {
        this.nomDeCompagnie = nomDeCompagnie;
    }

    public ArrayList<String> getInterets() {
        return interets;
    }

    public void setInterets(ArrayList<String> interets) {
        this.interets = interets;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getCapaciteFabrication() {
        return capaciteFabrication;
    }

    public void setCapaciteFabrication(int capaciteFabrication) {
        this.capaciteFabrication = capaciteFabrication;
    }
}
