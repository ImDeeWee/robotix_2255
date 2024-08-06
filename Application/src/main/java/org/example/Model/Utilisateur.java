package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Cette classe est utilisé pour les comptes utilisateur
 */
public class Utilisateur extends Compte {
    private String nom;
    private String prenom;
    private String nomDeCompagnie;
    private ArrayList<String> interets;
    private ArrayList<String> following;
    private ArrayList<String> followers;

    /**
     * Constructeur des fournisseur qui extend du constructeur de la classe
     * {@link org.example.Model.Compte}.
     * 
     * @param courriel       le courriel associé au compte.
     * @param pseudo         l'identifiant du compte
     * @param motDePasse     le mot de passe du compte
     * @param telephone      le numéro de téléphone du compte
     * @param nom            le nom de l'utilisateur
     * @param prenom         le prénom de l'utilisateur
     * @param nomDeCompagnie le nom de la compagnie de l'utilisateur
     * @param interets       la liste d'intérêts de l'utilisateur.
     */
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
    /**
     * Récupérer le nom de l'utilisateur.
     * 
     * @return le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom de l'utilisateur.
     * 
     * @param nom le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer le prénom de l'utilisateur.
     * 
     * @return le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifier le prénom de l'utilisateur.
     * 
     * @param prenom le nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Récupérer le nom de la compagnie de l'utilisateur.
     * 
     * @return le nom de la compagnie de l'utilisateur.
     */
    public String getNomDeCompagnie() {
        return nomDeCompagnie;
    }

    /**
     * Modifier le nom de la compagnie de l'utilisateur.
     * 
     * @param nomDeCompagnie le nouveau nom de compagnie.
     */
    public void setNomDeCompagnie(String nomDeCompagnie) {
        this.nomDeCompagnie = nomDeCompagnie;
    }

    /**
     * Récupérer la liste d'intérêts de l'utilisateur.
     * 
     * @return la liste d'intérêts de l'utilisateur.
     */
    public ArrayList<String> getInterets() {
        return interets;
    }

    /**
     * Modifier la liste d'intérêts de l'utilisateur.
     * 
     * @param interets la nouvelle liste d'intérêts.
     */
    public void setInterets(ArrayList<String> interets) {
        this.interets = interets;
    }

    /**
     * Récupérer la liste d'utilisateur que cet utilisateur follow.
     * 
     * @return la liste d'utilisateur que cet utilisateur follow.
     */
    public ArrayList<String> getFollowing() {
        return following;
    }

    /**
     * Modifier la liste d'utilisateur que cet utilisateur follow.
     * 
     * @param following la nouvelle liste de following.
     */
    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    /**
     * Récupère la liste d'utilisateurs qui follow cet utilisateur.
     * 
     * @return la liste de followers.
     */
    public ArrayList<String> getFollowers() {
        return followers;
    }

    /**
     * Modifier la liste d'utilisateurs qui follow cet utilisateur.
     * 
     * @param followers la nouvelle liste de followers.
     */
    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    /**
     * Rajouter un intérêt
     * 
     * @param interet l'intérêt à rajouter
     */
    public void addInteret(String interet) {
        this.interets.add(interet);
    }

    /**
     * Supprimer un intérêt.
     * 
     * @param interet l'intérêt à supprimer.
     */
    public void removeInteret(String interet) {
        this.interets.remove(interet);
    }

    /**
     * Follow quelqu'un
     * 
     * @param pseudo l'utilisateur à follow
     */
    public void addFollowing(String pseudo) {
        this.following.add(pseudo);
    }

    /**
     * Unfollow quelqu'un
     * 
     * @param pseudo l'utilisateur à unfollow.
     */
    public void removeFollowing(String pseudo) {
        this.following.remove(pseudo);
    }

    /**
     * Recevoir un nouveau follower.
     * 
     * @param pseudo le pseudo du nouveau follower.
     */
    public void addFollower(String pseudo) {
        this.followers.add(pseudo);
    }

    /**
     * Se faire unfollow par quelqu'un.
     * 
     * @param pseudo le pseudo de l'utilisateur qui a unfollow.
     */
    public void removeFollower(String pseudo) {
        this.followers.remove(pseudo);
    }

    /**
     * {@inheritDoc}
     * Caratéristique d'utilisateur
     */
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
