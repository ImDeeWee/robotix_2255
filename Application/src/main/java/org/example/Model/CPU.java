package org.example.Model;

public class CPU extends Composante {
    private Integer numeroDeSerie;

    public CPU(String nom, String description, Double prix, Boolean isDisponible, Integer numeroDeSerie) {
        super(nom, description, prix, ComposanteType.CPU, isDisponible);
        this.numeroDeSerie = numeroDeSerie;
    }

    public Integer getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Integer numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
}
