import java.util.ArrayList;

public class Robot {
    private CPU cpu;
    private String nom;
    private String type;
    private ArrayList<Composantes> composantesRobot;
    private ArrayList<Tache> taches;
    private ArrayList<Activite> activites; // Liste des activités

    public Robot(CPU cpu, String nom, String type) {
        this.cpu = cpu;
        this.nom = nom;
        this.type = type;
        this.composantesRobot = new ArrayList<>();
        this.taches = new ArrayList<>();
        this.activites = new ArrayList<>(); // Initialisation de la liste des activités
    }

    public Integer getnumeroDeSerie(){
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

    public ArrayList<Composantes> getComposantesRobot() {
        return composantesRobot;
    }

    public void setComposantesRobot(ArrayList<Composantes> composantesRobot) {
        this.composantesRobot = composantesRobot;
    }

    public void addComposante(Composantes composante) {
        this.composantesRobot.add(composante);
    }

    public void removeComposante(Composantes composante) {
        this.composantesRobot.remove(composante);
    }

    public boolean hasComponent(ComposanteType type) {
        for (Composantes composante : composantesRobot) {
            if (composante.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public void addTache(Tache tache) {
        taches.add(tache);
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

  
    public void addActivite(Activite activite) {
        activites.add(activite);
    }

    public void removeActivite(Activite activite) {
        activites.remove(activite);
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }
}

