package org.example.Controller;

import org.example.Model.Robot;
import org.example.Model.Composante;
import org.example.Model.ComposanteType;
import org.example.Model.Tache;
import org.example.Model.Activite;
import org.example.Model.CPU;

import java.util.ArrayList;

public class RobotController {
    private Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    public CPU getCpu() {
        return robot.getCpu();
    }

    public void setCpu(CPU cpu) {
        robot.setCpu(cpu);
    }

    public String getNom() {
        return robot.getNom();
    }

    public void setNom(String nom) {
        robot.setNom(nom);
    }

    public String getType() {
        return robot.getType();
    }

    public void setType(String type) {
        robot.setType(type);
    }

    public String getPosition() {
        return robot.getPosition();
    }

    public void setPosition(String position) {
        robot.setPosition(position);
    }

    public String getVitesse() {
        return robot.getVitesse();
    }

    public void setVitesse(String vitesse) {
        robot.setVitesse(vitesse);
    }

    public String getNiveauBatterie() {
        return robot.getNiveauBatterie();
    }

    public void setNiveauBatterie(String niveauBatterie) {
        robot.setNiveauBatterie(niveauBatterie);
    }

    public String getConsoCPU() {
        return robot.getConsoCPU();
    }

    public void setConsoCPU(String consoCPU) {
        robot.setConsoCPU(consoCPU);
    }

    public String getMemoire() {
        return robot.getMemoire();
    }

    public void setMemoire(String memoire) {
        robot.setMemoire(memoire);
    }

    public ArrayList<Composante> getComposantesRobot() {
        return robot.getComposantesRobot();
    }

    public void setComposantesRobot(ArrayList<Composante> composantesRobot) {
        robot.setComposantesRobot(composantesRobot);
    }

    public void addComposante(Composante composante) {
        robot.addComposante(composante);
    }

    public void removeComposante(Composante composante) {
        robot.removeComposante(composante);
    }

    public boolean hasComposante(ComposanteType type) {
        return robot.hasComposante(type);
    }

    public ArrayList<Tache> getTaches() {
        return robot.getTaches();
    }

    public void setTaches(ArrayList<Tache> taches) {
        robot.setTaches(taches);
    }

    public void addTache(Tache tache) {
        robot.addTache(tache);
    }

    public void removeTache(Tache tache) {
        robot.removeTache(tache);
    }

    public ArrayList<Activite> getActivites() {
        return robot.getActivites();
    }

    public void setActivites(ArrayList<Activite> activites) {
        robot.setActivites(activites);
    }

    public void addActivite(Activite activite) {
        robot.addActivite(activite);
    }

    public void removeActivite(Activite activite) {
        robot.removeActivite(activite);
    }

    public Integer getNumeroDeSerie() {
        return robot.getNumeroDeSerie();
    }

    public void afficherEtatRobot() {
        System.out.println("Position: " + robot.getPosition());
        System.out.println("Vitesse: " + robot.getVitesse());
        System.out.println("Niveau de Batterie: " + robot.getNiveauBatterie());
        System.out.println("Consommation CPU: " + robot.getConsoCPU());
        System.out.println("Mémoire: " + robot.getMemoire());
    }
}
