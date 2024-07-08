import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activite {
    private String nom;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<Tache> taches;
    private List<String> interets;
    private int points;

    public Activite(String nom, String description, Date startDate, Date endDate, int points) {
        this.nom = nom;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taches = new ArrayList<>();
        this.interets = new ArrayList<>();
        this.points = points;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void addTache(Tache tache) {
        this.taches.add(tache);
    }

    public void removeTache(Tache tache) {
        this.taches.remove(tache);
    }

    public List<String> getInterets() {
        return interets;
    }

    public void addInteret(String interet) {
        this.interets.add(interet);
    }

    public void removeInteret(String interet) {
        this.interets.remove(interet);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

