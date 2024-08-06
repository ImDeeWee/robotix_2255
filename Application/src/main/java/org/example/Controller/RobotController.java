package org.example.Controller;

import org.example.Model.Robot;
import org.example.Model.Composante;
import org.example.Model.ComposanteType;
import org.example.Model.Tache;
import org.example.Model.Activite;
import org.example.Model.CPU;

import java.util.ArrayList;

/**
 * Contrôleur pour la gestion des robots.
 */

public class RobotController {
    private Robot robot;

    /**
     * Constructeur de RobotController.
     * 
     * @param robot le robot géré par ce contrôleur.
     */

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    /**
     * Obtient le CPU du robot.
     * 
     * @return le CPU du robot.
     */

    public CPU getCpu() {
        return robot.getCpu();
    }

    /**
     * Définit le CPU du robot.
     * 
     * @param cpu le nouveau CPU du robot.
     */

    public void setCpu(CPU cpu) {
        robot.setCpu(cpu);
    }

    /**
     * Obtient le nom du robot.
     * 
     * @return le nom du robot.
     */

    public String getNom() {
        return robot.getNom();
    }

    /**
     * Définit le nom du robot.
     * 
     * @param nom le nouveau nom du robot.
     */

    public void setNom(String nom) {
        robot.setNom(nom);
    }

    /**
     * Obtient le type du robot.
     * 
     * @return le type du robot.
     */

    public String getType() {
        return robot.getType();
    }

    /**
     * Définit le type du robot.
     * 
     * @param type le nouveau type du robot.
     */

    public void setType(String type) {
        robot.setType(type);
    }

    /**
     * Obtient la position du robot.
     * 
     * @return la position du robot.
     */

    public String getPosition() {
        return robot.getPosition();
    }

    /**
     * Définit la position du robot.
     * 
     * @param position la nouvelle position du robot.
     */

    public void setPosition(String position) {
        robot.setPosition(position);
    }

    /**
     * Obtient la vitesse du robot.
     * 
     * @return la vitesse du robot.
     */

    public String getVitesse() {
        return robot.getVitesse();
    }

    /**
     * Définit la vitesse du robot.
     * 
     * @param vitesse la nouvelle vitesse du robot.
     */

    public void setVitesse(String vitesse) {
        robot.setVitesse(vitesse);
    }

    /**
     * Obtient le niveau de batterie du robot.
     * 
     * @return le niveau de batterie du robot.
     */

    public String getNiveauBatterie() {
        return robot.getNiveauBatterie();
    }

    /**
     * Définit le niveau de batterie du robot.
     * 
     * @param niveauBatterie le nouveau niveau de batterie du robot.
     */

    public void setNiveauBatterie(String niveauBatterie) {
        robot.setNiveauBatterie(niveauBatterie);
    }

    /**
     * Obtient la consommation CPU du robot.
     * 
     * @return la consommation CPU du robot.
     */

    public String getConsoCPU() {
        return robot.getConsoCPU();
    }

    /**
     * Définit la consommation CPU du robot.
     * 
     * @param consoCPU la nouvelle consommation CPU du robot.
     */

    public void setConsoCPU(String consoCPU) {
        robot.setConsoCPU(consoCPU);
    }

    /**
     * Obtient la mémoire du robot.
     * 
     * @return la mémoire du robot.
     */

    public String getMemoire() {
        return robot.getMemoire();
    }

    /**
     * Définit la mémoire du robot.
     * 
     * @param memoire la nouvelle mémoire du robot.
     */

    public void setMemoire(String memoire) {
        robot.setMemoire(memoire);
    }

    /**
     * Obtient les composantes du robot.
     * 
     * @return les composantes du robot.
     */

    public ArrayList<Composante> getComposantesRobot() {
        return robot.getComposantesRobot();
    }

    /**
     * Définit les composantes du robot.
     * 
     * @param composantesRobot les nouvelles composantes du robot.
     */

    public void setComposantesRobot(ArrayList<Composante> composantesRobot) {
        robot.setComposantesRobot(composantesRobot);
    }

    /**
     * Ajoute une composante au robot.
     * 
     * @param composante la composante à ajouter.
     */

    public void addComposante(Composante composante) {
        robot.addComposante(composante);
    }

    /**
     * Supprime une composante du robot.
     * 
     * @param composante la composante à supprimer.
     */

    public void removeComposante(Composante composante) {
        robot.removeComposante(composante);
    }

    /**
     * Vérifie si le robot a une composante de type spécifié.
     * 
     * @param type le type de la composante.
     * @return true si le robot a la composante, sinon false.
     */

    public boolean hasComposante(ComposanteType type) {
        return robot.hasComposante(type);
    }

    /**
     * Obtient les tâches du robot.
     * 
     * @return les tâches du robot.
     */

    public ArrayList<Tache> getTaches() {
        return robot.getTaches();
    }

    /**
     * Définit les tâches du robot.
     * 
     * @param taches les nouvelles tâches du robot.
     */

    public void setTaches(ArrayList<Tache> taches) {
        robot.setTaches(taches);
    }

    /**
     * Ajoute une tâche au robot.
     * 
     * @param tache la tâche à ajouter.
     */

    public void addTache(Tache tache) {
        robot.addTache(tache);
    }

    /**
     * Supprime une tâche du robot.
     * 
     * @param tache la tâche à supprimer.
     */

    public void removeTache(Tache tache) {
        robot.removeTache(tache);
    }

    /**
     * Obtient les activités du robot.
     * 
     * @return les activités du robot.
     */

    public ArrayList<Activite> getActivites() {
        return robot.getActivites();
    }

    /**
     * Définit les activités du robot.
     * 
     * @param activites les nouvelles activités du robot.
     */

    public void setActivites(ArrayList<Activite> activites) {
        robot.setActivites(activites);
    }

    /**
     * Ajoute une activité au robot.
     * 
     * @param activite l'activité à ajouter.
     */

    public void addActivite(Activite activite) {
        robot.addActivite(activite);
    }

    /**
     * Supprime une activité du robot.
     * 
     * @param activite l'activité à supprimer.
     */

    public void removeActivite(Activite activite) {
        robot.removeActivite(activite);
    }

    /**
     * Obtient le numéro de série du robot.
     * 
     * @return le numéro de série du robot.
     */

    public Integer getNumeroDeSerie() {
        return robot.getNumeroDeSerie();
    }

    /**
     * Affiche l'état du robot.
     */

    public void afficherEtatRobot() {
        System.out.println("Position: " + robot.getPosition());
        System.out.println("Vitesse: " + robot.getVitesse());
        System.out.println("Niveau de Batterie: " + robot.getNiveauBatterie());
        System.out.println("Consommation CPU: " + robot.getConsoCPU());
        System.out.println("Mémoire: " + robot.getMemoire());
    }
}
