package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
/**
 * Cette classe constitue les Emails qui sont utilisés pour confirmer
 * l'inscription des comptes.
 *
 * @see org.example.Model.Compte les comptes à inscrire.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    /**
     * Retourner le type du compte à confirmer la confirmation.
     * @return le type du compte
     */
    public String getType() {
        return type;
    }

    /**
     * Modifier le type du compte à confirmer la confirmation.
     * @param type le nouveau type de compte.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Récupérer le courriel associé avec l'email
     * @return le courriel
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Modifier le courriel associé avec cette email.
     * @param courriel ,  le nouveau courriel
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * Récupérer le pseudo du compte à confirmer l'inscription.
     * @return le pseudo du compte à confirmer l'inscription.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Modifier le pseudo du compte à confirmer l'inscription
     * @param pseudo , le nouveau pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Récupérer le mot de passe du compte à confirmer l'inscription.
     * @return  le mot de passe du compte.
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Modifie le mot de passe du compte à confirmer l'inscription
     * @param motDePasse    le nouveau mot de passe.
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Récupérer le numéro de téléphone du compte à confirmer l'inscription
     * @return le numéro de téléphone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Modifier le numéro de téléphone du compte à confirmer l'inscription.
     * @param telephone le nouveau numéro de téléophone.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Récupérer le nom associé au compte à confirmer l'inscription.
     * @return  le nom associé au compte à confirmer l'inscription.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom associé au compte à confirmer l'inscription.
     * @param nom   le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Récupérer le prénom associé au compte à confirmer l'inscription.
     * @return  le prénom associé au compte à confirmer l'inscription.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifier le prénom associé au compte à confirmer l'inscription.
     * @param prenom    le nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Récupérer le nom de la compagnie du compte à confirmer l'inscription.
     * @return  le nom de la compagnie du compte à confirmer l'inscription.
     */
    public String getNomDeCompagnie() {
        return nomDeCompagnie;
    }

    /**
     * Modifier le nom de la compagnie du compte à confirmer l'inscription.
     * @param nomDeCompagnie    le nouveau nom de compagnie
     */
    public void setNomDeCompagnie(String nomDeCompagnie) {
        this.nomDeCompagnie = nomDeCompagnie;
    }

    /**
     * Récupérer la liste d'intérêt du compte à confirmer l'inscription.
     * @return  la liste d'intérêt du compte à confirmer l'inscription.
     */
    public ArrayList<String> getInterets() {
        return interets;
    }

    /**
     * Modifier la liste d'intérêt du compte à confirmer l'inscription.
     * @param interets  la nouvelle liste d'intérêt
     */
    public void setInterets(ArrayList<String> interets) {
        this.interets = interets;
    }

    /**
     * Vérifie si la confirmation du compte a été confirmée.
     * @return  vrai si le compte est confirmé, faux sinon.
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Modifié la confirmation du compte
     * @param confirmed le nouveau état de confirmation.
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Récupérer la capacité de fabrication du compte à confirmer l'inscription.
     * @return  la capacité de fabrication du compte à confirmer l'inscription.
     */
    public int getCapaciteFabrication() {
        return capaciteFabrication;
    }

    /**
     * Modifier la capacité de fabrication du compte à confirmer l'inscription.
     * @param capaciteFabrication   la nouvelle capacité de fabrication
     */
    public void setCapaciteFabrication(int capaciteFabrication) {
        this.capaciteFabrication = capaciteFabrication;
    }
}
