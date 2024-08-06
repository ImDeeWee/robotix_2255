package org.example.Model;

public class Compte {
    protected String courriel;
    protected String pseudo;
    protected String motDePasse;
    protected String telephone;

    public Compte(String courriel, String pseudo, String motDePasse, String telephone) {
        this.courriel = courriel;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
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
}
