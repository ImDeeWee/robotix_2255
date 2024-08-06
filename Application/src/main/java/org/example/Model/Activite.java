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
     * @param nom       Le nom de l'activité.
     * @param points    Les points associés à l'activité.
     * @param dateDebut La date de début de l'activité.
     * @param dateFin   La date de fin de l'activité.
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

    /**
     * Recupérer le nom de l'activité
     * 
     * @return nom, le nom de l'activité
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom de l'activité
     * 
     * @param nom Le nouveau nom de l'activité
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer la liste de tâches de l'activité.
     * 
     * @return la liste de tâches de l'activité.
     */
    public ArrayList<Tache> getTaches() {
        return taches;
    }

    /**
     * Modifier la liste de tâches de l'activité.
     * 
     * @param taches la nouvelle liste de tâches de l'activité.
     */
    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    /**
     * Récupérer la liste d'intérêts associés à l'activité.
     * 
     * @return la liste d'intérêts associés à l'activité.
     */
    public ArrayList<String> getInterets() {
        return interets;
    }

    /**
     * Modifier la liste d'intérêts associés à l'activité.
     * 
     * @param interets la nouvelle liste d'intérêts associés à l'activité.
     */

    public void setInterets(ArrayList<String> interets) {
        this.interets = interets;
    }

    /**
     * Récupérer la liste d'auteur de l'activité.
     * 
     * @return la liste d'auteur de l'activité.
     */
    public ArrayList<Compte> getAuteurs() {
        return auteurs;
    }

    /**
     * Modifier la liste d'auteur de l'activité.
     * 
     * @param auteurs la nouvelle liste d'auteur de l'activité.
     */
    public void setAuteurs(ArrayList<Compte> auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * Récupérer le nombre de points offert par l'activité.
     * 
     * @return le nombre de points offert par l'activité.
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * Modifier le nombre de points offert par l'activité.
     * 
     * @param points le nouveau nombre de points offert par l'activité.
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * Retourne la date de commencement de l'activité.
     * 
     * @return la date de commencement de l'activité.
     */

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * Modifier la date de commencement de l'activité.
     * 
     * @param dateDebut la nouvelle date de commencement de l'activité.
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Récupérer la date de fin de l'activité.
     * 
     * @return la date de fin de l'activité.
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Modifier la date de fin de l'activité.
     * 
     * @param dateFin la nouvelle date de fin de l'activité.
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Ajouter une nouvelle tâche à l'activité.
     * 
     * @param tache la nouvelle tâche
     */
    public void addTache(Tache tache) {
        this.taches.add(tache);
    }

    /**
     * Retirer un tâche de l'activité
     * 
     * @param tache la tâche à supprimer
     */
    public void removeTache(Tache tache) {
        this.taches.remove(tache);
    }

    /**
     * Ajouter une nouvel intérêt à l'activité.
     * 
     * @param interet le nouvel intérêt à ajouter.
     */
    public void addInteret(String interet) {
        this.interets.add(interet);
    }

    /**
     * Supprimer un intérêt de l'activité.
     * 
     * @param interet l'intérêt à supprimer.
     */
    public void removeInteret(String interet) {
        this.interets.remove(interet);
    }

    /**
     * Rajouter un nouveau auteur à l'activité.
     * 
     * @param auteur le compte du nouveau auteur.
     */
    public void addAuteur(Compte auteur) {
        this.auteurs.add(auteur);
    }

    /**
     * Supprimer un auteur de l'activité.
     * 
     * @param auteur l'auteur à supprimer.
     */
    public void removeAuteur(Compte auteur) {
        this.auteurs.remove(auteur);
    }

    /**
     * Recupérer les informations générales de la liste dans un String.
     */
    public String toString() {
        return "Points: " + points + ", Date de début: " + dateDebut + ", Date de fin: " + dateFin;
    }

    /**
     * Retourner les numéros de série de tous les robots associés à l'activité.
     * 
     * @return un liste de tous les robots associés à l'activité.
     */
    public List<Integer> getNumeroDeSerieRobots() {
        return numeroDeSerieRobots;
    }

    /**
     * Rajouter un robot à l'activité à l'aide de son numéro de série.
     * 
     * @param numeroDeSerie le numéro de série du robot à associer à l'activité.
     */
    public void addNumeroDeSerieRobot(Integer numeroDeSerie) {
        this.numeroDeSerieRobots.add(numeroDeSerie);
    }

    /**
     * Enlever un robot de l'activité.
     * 
     * @param numeroDeSerie le numnéro de série du robot à enlever.
     */
    public void removeNumeroDeSerieRobot(Integer numeroDeSerie) {
        this.numeroDeSerieRobots.remove(numeroDeSerie);
    }

}
