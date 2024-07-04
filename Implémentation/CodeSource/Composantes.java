public class Composantes {
    private String nom;
    private String description;
    private Double prix;
    private Boolean isDisponible;
    private ComposanteType type;


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
    

        public Double getPrix() {
            return prix;
        }
    

        public void setPrix(Double prix) {
            this.prix = prix;
        }
    

        public Boolean getIsDisponible() {
            return isDisponible;
        }
    

        public void setIsDisponible(Boolean isDisponible) {
            this.isDisponible = isDisponible;
        }

        public ComposanteType getType() {
            return type;
        }
    

        public void setType(ComposanteType type) {
            this.type = type;
        }
}
