package org.example.Model;

/**
 * Cette classe représente les comptes de l'application Robotix.
 */
public class Compte {

    protected String courriel;
    protected String pseudo;
    protected String motDePasse;
    protected String telephone;

    /**
     * Constructeur pour la création d'un nouveau compte.
     * 
     * @param courriel   le courriel associé au compte.
     * @param pseudo     l'identifiant du compte
     * @param motDePasse le mot de passe du compte
     * @param telephone  le numéro de téléphone du compte
     */
    public Compte(String courriel, String pseudo, String motDePasse, String telephone) {
        this.courriel = courriel;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
    }

    /**
     * Récupérer le courriel du compte.
     * 
     * @return le courriel du comppte.
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Modifier le courriel du compte
     * 
     * @param courriel le nouveau courriel du compte.
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * Récupérer le pseudonyme du compte.
     * 
     * @return le pseudonyme du compte.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Modifier le pseudonyme du compte.
     * 
     * @param pseudo le nouveau pseudo du compte.
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Récupérer le mot de passe du compte.
     * 
     * @return le mot de passe du compte.
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Modifier le mot de passe du compte.
     * 
     * @param motDePasse le nouveau mot de passe du compte.
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Récuperer le numéro de téléphone du compte.
     * 
     * @return le numéro de téléphone du compte
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Modifier le numéro de téléphone du compte.
     * 
     * @param telephone le nouveau numéro de téléphone.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
