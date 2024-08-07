import java.util.ArrayList;

public class ArbreCompte extends ArbreBinaireRecherche{
    class Compte extends Noeud{
        private String nom;
        private String prenom;
        private String courriel;
        private String adresse;
        private Integer capaciteFabrication;
        private Integer phone;

        private String compagnie;
        TypeCompte accountType;


        private ArrayList<Compte> followers;
        private ArrayList<Compte> following;
        private ArrayList<String> interets;

        public Integer getCapaciteFabrication(){
            return capaciteFabrication;
        }
        public void setCapaciteFabrication(Integer capacite){
            this.capaciteFabrication = capacite;
        }

        public ArrayList<String> getInterets(){
            return interets;
        }
    
        public void addInteret(String interet) {
            this.interets.add(interet);
        }
    
        public void removeInteret(String interet) {
            this.interets.remove(interet);
        }       

        public ArrayList<Compte> getFollowers(){
            return followers;
        }
    
        public void addFollower(Compte Compte) {
            this.followers.add(Compte);
        }
    
        public void removeFollower(Compte Compte) {
            this.followers.remove(Compte);
        }
    
        public ArrayList<Compte> getFollowing(){
            return following;
        }
    
        public void addFollowing(Compte Compte) {
            this.following.add(Compte);
        }
    
        public void removeFollowing(Compte Compte) {
            this.following.remove(Compte);
        }

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
         // Il manquera la liste d'interet a implementer pour les Comptes.

        public Compte(String nomFournisseur, String password, String adresse,String courriel, Integer phone, String compagnie)  { //Fournisseur
            super(nomFournisseur, password);
            setCourriel(courriel);
            setPhone(phone);
            this.adresse = adresse;
            this.accountType = TypeCompte.Fournisseur;
            setCompagnie(compagnie);
            this.followers = new ArrayList<Compte>();
            this.following = new ArrayList<Compte>();
            this.interets = new ArrayList<String>();
        }
        public Compte(String pseudo, String password, String nom, String prenom, String courriel, Integer phone) { //Compte sans compagnie
            super(pseudo, password);
            setNom(nom);
            setPrenom(prenom);
            setCourriel(courriel);
            setPhone(phone);
            this.accountType = TypeCompte.Utiliisateur;
            setCompagnie(null);
            this.followers = new ArrayList<Compte>();
            this.following = new ArrayList<Compte>();
            this.interets = new ArrayList<String>();
        }
        public Compte(String pseudo, String password, String nom, String prenom, String courriel, Integer phone, String compagnie) { //Compte avec compagnie
            super(pseudo, password);
            setNom(nom);
            setPrenom(prenom);
            setCourriel(courriel);
            setPhone(phone);
            setCompagnie(compagnie);
            this.accountType = TypeCompte.Utiliisateur;
            this.followers = new ArrayList<Compte>();
            this.following = new ArrayList<Compte>();
            this.interets = new ArrayList<String>();
        }
    }


    public void insert(Inscription.NewAccount newAccount) {
        root = insert((Compte) root, newAccount);
    }

    private Compte insert(Compte root, Inscription.NewAccount newAccount) {
        if (root == null) {
            if (newAccount.getAccountType() == TypeCompte.Fournisseur) {
                root = new Compte(newAccount.getPseudonyme(),newAccount.getPassword(),newAccount.getAdresse(),newAccount.getEmail(),newAccount.getPhoneNumber(),newAccount.getCompagnie());
            } else {
                if (newAccount.getCompagnie() == null) {
                    root = new Compte(newAccount.getPseudonyme(), newAccount.getPassword(), newAccount.getNom(), newAccount.getPrenom(), newAccount.getEmail(), newAccount.getPhoneNumber());
                } else {
                    root = new Compte(newAccount.getPseudonyme(), newAccount.getPassword(), newAccount.getNom(), newAccount.getPrenom(), newAccount.getEmail(), newAccount.getPhoneNumber(), newAccount.getCompagnie());
                }
            }
            size++;
            return root;
        }
        String data = newAccount.getPseudonyme();
        if (data.compareTo(root.getIdentifiant()) < 0) {
            root.left = insert((Compte) root.left, newAccount);
        } else if (data.compareTo(root.getIdentifiant()) > 0) {
            root.right = insert((Compte) root.right, newAccount);
        }
        return root;
    }

    public Compte getCompte(String pseudo) {
        return getCompteRec((Compte) root, pseudo);
    }

    private Compte getCompteRec(Compte root, String pseudo) {
        if (root == null || root.getIdentifiant().equals(pseudo)) {
            return root;
        }
        if (pseudo.compareTo(root.getIdentifiant()) < 0) {
            return getCompteRec((Compte) root.left, pseudo);
        } else {
            return getCompteRec((Compte) root.right, pseudo);
        }
    }

    public Compte getCompteWEmail(String email) {
        return getCompteWEmailRec((Compte) root, email);
    }

    private Compte getCompteWEmailRec(Compte root, String email) {
        if (root == null) {
            return null;
        }
        if (root.getCourriel().equals(email)) {
            return root;
        }
        Compte found = getCompteWEmailRec((Compte) root.left, email);
        if (found == null) {
            found = getCompteWEmailRec((Compte) root.right, email);
        }
        return found;
    }

    public boolean isEmailPresent(String email) {
        return containsEmail((Compte) root, email);
    }

    private boolean containsEmail(Compte root, String email) {
        if (root == null) {
            return false;
        }
        if (root.getCourriel().equals(email)) {
            return true;
        }
        return containsEmail((Compte) root.left, email) || containsEmail((Compte) root.right, email);
    }
}