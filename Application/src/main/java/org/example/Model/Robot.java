package org.example.Model;
import java.util.ArrayList;

public class Robot {
    private CPU cpu;
    private String nom;
    private String type;
    private String position;
    private String vitesse;
    private String niveauBatterie;
    private String consoCPU;
    private String memoire;
    private ArrayList<Composante> composantesRobot;
    private ArrayList<Tache> taches;
    private ArrayList<Activite> activites; 

    public Robot(CPU cpu, String nom, String type, String position, String vitesse, String niveauBatterie, String consoCPU, String memoire) {
        this.cpu = cpu;
        this.nom = nom;
        this.type = type;
        this.position = position;
        this.vitesse = vitesse;
        this.niveauBatterie = niveauBatterie;
        this.consoCPU = consoCPU;
        this.memoire = memoire;
        this.composantesRobot = new ArrayList<>();
        this.taches = new ArrayList<>();
        this.activites = new ArrayList<>(); 
    }

    public Integer getNumeroDeSerie(){
        return cpu.getNumeroDeSerie();
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVitesse() {
        return vitesse;
    }

    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }

    public String getNiveauBatterie() {
        return niveauBatterie;
    }

    public void setNiveauBatterie(String niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    public String getConsoCPU() {
        return consoCPU;
    }

    public void setConsoCPU(String consoCPU) {
        this.consoCPU = consoCPU;
    }

    public String getMemoire() {
        return memoire;
    }

    public void setMemoire(String memoire) {
        this.memoire = memoire;
    }

    public ArrayList<Composante> getComposantesRobot() {
        return composantesRobot;
    }

    public void setComposantesRobot(ArrayList<Composante> composantesRobot) {
        this.composantesRobot = composantesRobot;
    }

    public void addComposante(Composante composante) {
        this.composantesRobot.add(composante);
    }

    public void removeComposante(Composante composante) {
        this.composantesRobot.remove(composante);
    }

    public boolean hasComposante(ComposanteType type) {
        for (Composante composante : composantesRobot) {
            if (composante.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    public void addTache(Tache tache) {
        this.taches.add(tache);
    }

    public void removeTache(Tache tache) {
        this.taches.remove(tache);
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

    public void addActivite(Activite activite) {
        this.activites.add(activite);
    }

    public void removeActivite(Activite activite) {
        this.activites.remove(activite);
    }
}


