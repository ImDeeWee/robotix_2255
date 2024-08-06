package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fournisseur extends Compte {
    private Integer capaciteFabrication;

    public Fournisseur(@JsonProperty("courriel") String courriel,
                       @JsonProperty("pseudo") String pseudo,
                       @JsonProperty("motDePasse") String motDePasse,
                       @JsonProperty("telephone") String telephone,
                       @JsonProperty("capaciteFabrication") Integer capaciteFabrication) {
        super(courriel, pseudo, motDePasse, telephone);
        this.capaciteFabrication = capaciteFabrication;
    }

    // Getters et setters

    public Integer getCapaciteFabrication() {
        return capaciteFabrication;
    }

    public void setCapaciteFabrication(Integer capaciteFabrication) {
        this.capaciteFabrication = capaciteFabrication;
    }

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
