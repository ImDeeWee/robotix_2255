public class Composantes {
    private String nom;
    private String description;
    private double prix;
    private ComposanteType type;
    private boolean isDisponible;

    // Constructeur existant ou par défaut, si nécessaire
    public Composantes() {
    }

    // Nouveau constructeur
    public Composantes(String nom, String description, double prix, ComposanteType type, boolean isDisponible) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.type = type;
        this.isDisponible = isDisponible;
    }

    // Getters et setters pour les attributs

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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ComposanteType getType() {
        return type;
    }

    public void setType(ComposanteType type) {
        this.type = type;
    }

    public boolean getIsDisponible() {
        return isDisponible;
    }

    public void setIsDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
}

