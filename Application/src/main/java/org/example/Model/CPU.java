package org.example.Model;

/**
 * Cette classe est la composante CPU, qui est obligatoire pour la construction
 * d'un robot.
 */
public class CPU extends Composante {
    private Integer numeroDeSerie;

    /**
     * Constructeur du CPU, qui extend du constructeur de la classe
     * {@link org.example.Model.CPU}.
     * 
     * @param nom           Nom de la composante.
     * @param description   Une description de la composante.
     * @param prix          le prix de la composante.
     * @param type          le type de la composante.
     * @param isDisponible  si la composante est disponible ou non
     * @param numeroDeSerie le numéro de série du CPU et du Robot associé avec.
     */
    public CPU(String nom, String description, Double prix, Boolean isDisponible, Integer numeroDeSerie) {
        super(nom, description, prix, ComposanteType.CPU, isDisponible);
        this.numeroDeSerie = numeroDeSerie;
    }

    /**
     * Récupérer le numéro de série.
     * 
     * @return le numéro de série.
     */
    public Integer getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * Modifier le numéro de série.
     * 
     * @param numeroDeSerie le nouveau numéro de série.
     */
    public void setNumeroDeSerie(Integer numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
}
