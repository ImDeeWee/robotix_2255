package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cette classe représente les comptes de fournisseurs.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fournisseur extends Compte {
    private Integer capaciteFabrication;

    /**
     * Constructeur des fournisseurs qui extend du constructeur de la classe
     * {@link org.example.Model.Compte}.
     * 
     * @param courriel            le courriel associé au compte.
     * @param pseudo              l'identifiant du compte
     * @param motDePasse          le mot de passe du compte
     * @param telephone           le numéro de téléphone du compte
     * @param capaciteFabrication la capacité de fabrication du fournisseur.
     */
    public Fournisseur(@JsonProperty("courriel") String courriel,
            @JsonProperty("pseudo") String pseudo,
            @JsonProperty("motDePasse") String motDePasse,
            @JsonProperty("telephone") String telephone,
            @JsonProperty("capaciteFabrication") Integer capaciteFabrication) {
        super(courriel, pseudo, motDePasse, telephone);
        this.capaciteFabrication = capaciteFabrication;
    }

    // Getters et setters
    /**
     * Récupérer la capacité de fabtication du fournisseur.
     * 
     * @return la capacité de fabtication du fournisseur.
     */
    public Integer getCapaciteFabrication() {
        return capaciteFabrication;
    }

    /**
     * Modifier la capacité de fabtication du fournisseur.
     * 
     * @param capaciteFabrication la nouvelle capacité de fabtication du
     *                            fournisseur.
     */
    public void setCapaciteFabrication(Integer capaciteFabrication) {
        this.capaciteFabrication = capaciteFabrication;
    }

    /**
     * {@inheritDoc}
     * Caracteristique de fournisseur.
     */
    @Override
    public String toString() {
        return "Fournisseur{" +
                "capaciteFabrication=" + capaciteFabrication +
                ", courriel='" + courriel + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
