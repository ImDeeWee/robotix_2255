public class ArbreBinaireRecherche {
    // Classe interne pour représenter un nœud de l'arbre
    class Noeud {
        public String getIdentifiant() {
            return identifiant;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setIdentifiant(String identifiant){
            this.identifiant = identifiant;
        }

        private String identifiant;
        private String password;
        Noeud left, right;

        public Noeud(String identifiant, String password) {
            setIdentifiant(identifiant);
            setPassword(password);
            this.left = this.right = null;
        }
    }


    Noeud root;
    int size;


    ArbreBinaireRecherche() {
        root = null;
        size = 0;
    }

    // Méthode pour insérer un nouvel élément dans l'arbre
    public void insert(String data, String password) {
        root = insertRec(root, data, password);
    }

    // Méthode récursive pour insérer un nouvel élément dans l'arbre
    private Noeud insertRec(Noeud root, String data, String password) {
        // Si l'arbre est vide, retourner un nouveau nœud
        if (root == null) {
            root = new Noeud(data, password);
            size++;
            return root;
        }

        // Sinon, parcourir l'arbre
        if (data.compareTo(root.identifiant) < 0)
            root.left = insertRec(root.left, data, password);
        else if (data.compareTo(root.identifiant) > 0)
            root.right = insertRec(root.right, data, password);

        // Retourner le nœud (non modifié)
        return root;
    }
    public boolean isNodePresent(String data) {
        return containsRec(root, data);
    }

    private boolean containsRec(Noeud root, String data) {
        // Si l'arbre est vide ou si on atteint un nœud feuille
        if (root == null) {
            return false;
        }
        // Si la valeur du nœud courant est égale à la donnée recherchée
        if (root.identifiant.equals(data)) {
            return true;
        }
        // Sinon, rechercher dans le sous-arbre gauche ou droit
        if (data.compareTo(root.identifiant) < 0) {
            return containsRec(root.left, data);
        } else {
            return containsRec(root.right, data);
        }
    }

    // Méthode pour retourner le nœud avec le data spécifié
    public Noeud getNode(String data) {
        return getNodeRec(root, data);
    }

    // Méthode récursive pour retourner le nœud avec le data spécifié
    private Noeud getNodeRec(Noeud root, String data) {
        // Si l'arbre est vide ou si on atteint un nœud feuille
        if (root == null || root.identifiant.equals(data)) {
            return root;
        }
        // Sinon, rechercher dans le sous-arbre gauche ou droit
        if (data.compareTo(root.identifiant) < 0) {
            return getNodeRec(root.left, data);
        } else {
            return getNodeRec(root.right, data);
        }
    }
    public void changeNode(String data, Noeud newNode) {
        root = changeNodeRec(root, data, newNode);
    }

    // Méthode récursive pour remplacer un nœud existant par un nouveau nœud
    private Noeud changeNodeRec(Noeud root, String data, Noeud newNode) {
        // Si l'arbre est vide, retourner null
        if (root == null) {
            return null;
        }

        // Si le nœud à remplacer est trouvé
        if (root.identifiant.equals(data)) {
            newNode.left = root.left;
            newNode.right = root.right;
            return newNode;
        }

        // Sinon, parcourir l'arbre pour trouver le nœud à remplacer
        if (data.compareTo(root.identifiant) < 0) {
            root.left = changeNodeRec(root.left, data, newNode);
        } else {
            root.right = changeNodeRec(root.right, data, newNode);
        }

        return root;
    }











    // Cette méthode appelle la méthode inorderRec()
    void inorder() {
        inorderRec(root);
    }

    // Méthode récursive pour effectuer un parcours en ordre (inorder) de l'arbre
    void inorderRec(Noeud root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.identifiant + " ");
            inorderRec(root.right);
        }
    }
}
