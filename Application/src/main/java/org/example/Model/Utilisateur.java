package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Utilisateur extends Compte {
    private String nom;
    private String prenom;
    private String nomDeCompagnie;
    private ArrayList<String> interets;
    private ArrayList<String> following;
    private ArrayList<String> followers;

    public Utilisateur(@JsonProperty("courriel") String courriel,
                       @JsonProperty("pseudo") String pseudo,
                       @JsonProperty("motDePasse") String motDePasse,
                       @JsonProperty("telephone") String telephone,
                       @JsonProperty("nom") String nom,
                       @JsonProperty("prenom") String prenom,
                       @JsonProperty("nomDeCompagnie") String nomDeCompagnie,
                       @JsonProperty("interets") ArrayList<String> interets) {
        super(courriel, pseudo, motDePasse, telephone);
        this.nom = nom;
        this.prenom = prenom;
        this.nomDeCompagnie = (nomDeCompagnie != null) ? nomDeCompagnie : "";
        this.interets = (interets != null) ? interets : new ArrayList<>();
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    // Getters et setters

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

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public void addInteret(String interet) {
        this.interets.add(interet);
    }

    public void removeInteret(String interet) {
        this.interets.remove(interet);
    }

    public void addFollowing(String pseudo) {
        this.following.add(pseudo);
    }

    public void removeFollowing(String pseudo) {
        this.following.remove(pseudo);
    }

    public void addFollower(String pseudo) {
        this.followers.add(pseudo);
    }

    public void removeFollower(String pseudo) {
        this.followers.remove(pseudo);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomDeCompagnie='" + nomDeCompagnie + '\'' +
                ", interets=" + interets +
                ", courriel='" + courriel + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
