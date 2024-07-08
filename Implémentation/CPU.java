public class CPU extends Composantes {
    private Integer numeroDeSerie;

    public Integer getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Integer numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public CPU() {
        super();
        this.setType(ComposanteType.CPU);
    }

    public CPU(String nom, String description, Double prix, Boolean isDisponible) {
        super();
        this.setNom(nom);
        this.setDescription(description);
        this.setPrix(prix);
        this.setIsDisponible(isDisponible);
        this.setType(ComposanteType.CPU);
    }
}
