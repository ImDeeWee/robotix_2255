package org.example.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une activité.
 */

public class Activite {
    private String nom;
    private ArrayList<Tache> taches;
    private List<Integer> numeroDeSerieRobots;
    private ArrayList<String> interets;
    private ArrayList<Compte> auteurs;
    private Integer points;
    private LocalDate dateDebut;
    private LocalDate dateFin;

     /**
     * Constructeur de la classe Activite.
     *
     * @param nom        Le nom de l'activité.
     * @param points     Les points associés à l'activité.
     * @param dateDebut  La date de début de l'activité.
     * @param dateFin    La date de fin de l'activité.
     */

    public Activite(String nom, Integer points, LocalDate dateDebut, LocalDate dateFin) {
        this.nom = nom;
        this.taches = new ArrayList<>();
        this.numeroDeSerieRobots = new ArrayList<>();
        this.interets = new ArrayList<>();
        this.auteurs = new ArrayList<>();
        this.points = points;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    public ArrayList<String> getInterets() {
        return interets;
    }

    public void setInterets(ArrayList<String> interets) {
        this.interets = interets;
    }

    public ArrayList<Compte> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList<Compte> auteurs) {
        this.auteurs = auteurs;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void addTache(Tache tache) {
        this.taches.add(tache);
    }

    public void removeTache(Tache tache) {
        this.taches.remove(tache);
    }

    public void addInteret(String interet) {
        this.interets.add(interet);
    }

    public void removeInteret(String interet) {
        this.interets.remove(interet);
    }

    public void addAuteur(Compte auteur) {
        this.auteurs.add(auteur);
    }

    public void removeAuteur(Compte auteur) {
        this.auteurs.remove(auteur);
    }

    public String toString() {
        return "Points: " + points + ", Date de début: " + dateDebut + ", Date de fin: " + dateFin;
    }

    public List<Integer> getNumeroDeSerieRobots() {
        return numeroDeSerieRobots;
    }

    public void addNumeroDeSerieRobot(Integer numeroDeSerie) {
        this.numeroDeSerieRobots.add(numeroDeSerie);
    }

    public void removeNumeroDeSerieRobot(Integer numeroDeSerie) {
        this.numeroDeSerieRobots.remove(numeroDeSerie);
    }

}
