package org.example.Model;

/**
 * Cette classe représente les composantes pour les robots ainsi que ces
 * caractéristiques.
 */
public class Composante {
    private String nom;
    private String description;
    private double prix;
    private ComposanteType type;
    private boolean isDisponible;

    /**
     * Constructeur vide des composantes pour la lecture du fichier Composante.json
     * 
     * @see <a href="src\main\java\Donnees\Composantes.json">Composantes.json<\a>
     */
    public Composante() {
    }

    /**
     * Constructeur des composantes
     * 
     * @param nom          Nom de la composante.
     * @param description  Une description de la composante.
     * @param prix         le prix de la composante.
     * @param type         le type de la composante.
     * @param isDisponible si la composante est disponible ou non
     */
    public Composante(String nom, String description, double prix, ComposanteType type, boolean isDisponible) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.type = type;
        this.isDisponible = isDisponible;
    }

    /**
     * Récupérer le nom de la composante.
     * 
     * @return le nom de la composante.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom de la composante.
     * 
     * @param nom nouveau nom de la composante.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer la description de la composante.
     * 
     * @return la description de la composante.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifier la description de la composante.
     * 
     * @param description la nouvelle description de la composante.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Récupérer le prix de la composante.
     * 
     * @return le prix de la composante.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Modifier le prix de la composante.
     * 
     * @param prix le nouveau prix de la composante.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Récupérer le type de la composante.
     * 
     * @return le type de la composante.
     */
    public ComposanteType getType() {
        return type;
    }

    /**
     * Modifier le type de la composante.
     * 
     * @param type le nouveau type de la composante.
     */
    public void setType(ComposanteType type) {
        this.type = type;
    }

    /**
     * Récupérer la disponibilité de la composante
     * 
     * @return vrai si disponible, faux sinon.
     */
    public boolean getIsDisponible() {
        return isDisponible;
    }

    /**
     * Modifier la disponibilité de la composante
     * 
     * @param isDisponible la nouvelle disponibilité
     */
    public void setIsDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
}
