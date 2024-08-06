package org.example.Model;

import java.util.ArrayList;

/**
 * Cette represente les robots des comptes.
 */
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

    /**
     * Constructeur d'un robot
     * 
     * @param cpu            le CPU du Robot
     * @param nom            le nom du Robot.
     * @param type           le type du Robot
     * @param position       la position du Robot
     * @param vitesse        la vitesse du Robot
     * @param niveauBatterie le niveau de batterie du Robot
     * @param consoCPU       la consomation du CPU du Robot
     * @param memoire        la mémoire vive du Robot
     */
    public Robot(CPU cpu, String nom, String type, String position, String vitesse, String niveauBatterie,
            String consoCPU, String memoire) {
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

    /**
     * Récupérer le numéro de série du robot.
     *
     * @return le numéro de série du robot.
     * @see la fonction getNumeroDeSerie() de la classe CPU.
     */
    public Integer getNumeroDeSerie() {
        return cpu.getNumeroDeSerie();
    }

    /**
     * Récupérer le CPU du robot.
     * 
     * @return le CPU du robot.
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Modifier le cpu du robot.
     * 
     * @param cpu le nouveau CPU du robot.
     */
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    /**
     * Récupérer le nom du robot.
     * 
     * @return le nom du robot.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom du robot.
     * 
     * @param nom le nouveau nom du robot.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer le type du robot
     * 
     * @return le type du robot.
     */
    public String getType() {
        return type;
    }

    /**
     * Modifier le type du robot
     * 
     * @param type le nouveau type du robot.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Récupérer la position du robot.
     * 
     * @return la position du robot.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Modifier la position du robot.
     * 
     * @param position la nouvelle position du robot.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Récupérer la vitesse du robot.
     * 
     * @return la vitesse du robot.
     */
    public String getVitesse() {
        return vitesse;
    }

    /**
     * Modifier la vitesse du robot.
     * 
     * @param vitesse la nouvelle vitesse du robot.
     */
    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Récupérer le niveau de batterie du robot.
     * 
     * @return le niveau de batterie du robot.
     */
    public String getNiveauBatterie() {
        return niveauBatterie;
    }

    /**
     * Modifier le niveau de batterie du robot.
     * 
     * @param niveauBatterie le nouveau niveau de batterie du robot.
     */
    public void setNiveauBatterie(String niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    /**
     * Récupérer la consomation du CPU du robot.
     * 
     * @return la consomation du CPU du robot.
     */
    public String getConsoCPU() {
        return consoCPU;
    }

    /**
     * Modifier la consomation du CPU du robot.
     * 
     * @param consoCPU la nouvelle consomation du CPU du robot.
     */
    public void setConsoCPU(String consoCPU) {
        this.consoCPU = consoCPU;
    }

    /**
     * Récupérer la mémoire du robot.
     * 
     * @return la mémoire du robot.
     */
    public String getMemoire() {
        return memoire;
    }

    /**
     * Modifier la mémoire du robot.
     * 
     * @param memoire la nouvelle mémoire du robot.
     */
    public void setMemoire(String memoire) {
        this.memoire = memoire;
    }

    /**
     * Récupérer la liste de composantes du robot
     * 
     * @return la liste de composantes du robot.
     */
    public ArrayList<Composante> getComposantesRobot() {
        return composantesRobot;
    }

    /**
     * Modifier la liste de composantes du robot.
     * 
     * @param composantesRobot la nouvelle liste de composante du robot.
     */
    public void setComposantesRobot(ArrayList<Composante> composantesRobot) {
        this.composantesRobot = composantesRobot;
    }

    /**
     * Rajouter une nouvelle composante au robot.
     * 
     * @param composante la nouvelle composante à rajouter
     */
    public void addComposante(Composante composante) {
        this.composantesRobot.add(composante);
    }

    /**
     * Supprimer une composante au robot.
     * 
     * @param composante la composante à supprimer.
     */
    public void removeComposante(Composante composante) {
        this.composantesRobot.remove(composante);
    }

    /**
     * Vérifie si le robot possède déjà un certain type de composante.
     * 
     * @param type le type de composante
     * @return vrai si le robot possède une composante du type composante, faux
     *         sinon
     */
    public boolean hasComposante(ComposanteType type) {
        for (Composante composante : composantesRobot) {
            if (composante.getType() == type) {
                return true;
            }
        }
        return false;
    }

    /**
     * Récupérer la liste d'activités du robot.
     * 
     * @return la liste d'activités du robot.
     */
    public ArrayList<Tache> getTaches() {
        return taches;
    }

    /**
     * Modifier la liste d'activités du robot.
     * 
     * @param taches la nouvelle liste d'activités.
     */
    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    /**
     * Rajouter un tâche au robot.
     * 
     * @param tache la tâche à rajouter.
     */
    public void addTache(Tache tache) {
        this.taches.add(tache);
    }

    /**
     * Supprimer une tâche au robot.
     * 
     * @param tache la tâche à supprimer.
     */
    public void removeTache(Tache tache) {
        this.taches.remove(tache);
    }

    /**
     * Récupérer la liste d'activités du robot.
     * 
     * @return la liste d'activités du robot.
     */
    public ArrayList<Activite> getActivites() {
        return activites;
    }

    /**
     * Modifier la liste d'activités du robot.
     * 
     * @param activites la nouvelle liste d'activités du robot.
     */
    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

    /**
     * Rajouter un activité au robot.
     * 
     * @param activite l'activité à rajouter
     */
    public void addActivite(Activite activite) {
        this.activites.add(activite);
    }

    /**
     * Supprimer un activité au robot
     * 
     * @param activite l'activité à supprimer.
     */
    public void removeActivite(Activite activite) {
        this.activites.remove(activite);
    }
}
