public class ArbreCompte extends ArbreBinaireRecherche{
    class Compte extends Noeud{
        String nom;
        String prenom;
        String courriel;
        String adresse;

        int phone;

        String compagnie;
        TypeCompte accountType;

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getCourriel() {
            return courriel;
        }

        public void setCourriel(String courriel) {
            this.courriel = courriel;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public String getCompagnie() {
            return compagnie;
        }

        public void setCompagnie(String compagnie) {
            this.compagnie = compagnie;
        }
         // Il manquera la liste d'interet a implementer pour les utilisateurs.

        public Compte(String pseudo, String password, String nom, String prenom, String adresse,String courriel, int phone, String compagnie) {
            super(pseudo, password);
            setNom(nom);
            setPrenom(prenom);
            setCourriel(courriel);
            setPhone(phone);
            this.adresse = adresse;
            this.accountType = TypeCompte.Fournisseur;
            setCompagnie(compagnie);

        }
        public Compte(String pseudo, String password, String nom, String prenom, String courriel, int phone) {
            super(pseudo, password);
            setNom(nom);
            setPrenom(prenom);
            setCourriel(courriel);
            setPhone(phone);
            this.accountType = TypeCompte.Utiliisateur;
            setCompagnie(null);
        }
        public Compte(String pseudo, String password, String nom, String prenom, String courriel, int phone, String compagnie) {
            super(pseudo, password);
            setNom(nom);
            setPrenom(prenom);
            setCourriel(courriel);
            setPhone(phone);
            setCompagnie(compagnie);
            this.accountType = TypeCompte.Utiliisateur;
        }
    }







}
