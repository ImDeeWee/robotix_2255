public class ArbreBinaireRecherche {
    // Classe interne pour représenter un nœud de l'arbre
    class Noeud {
        String identifiant;
        String password;
        Noeud left, right;

        public Noeud(String identifiant, String password) {
            this.identifiant = identifiant;
            this.password = password;
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
    void insert(String data, String password) {
        root = insertRec(root, data, password);
    }

    // Méthode récursive pour insérer un nouvel élément dans l'arbre
    Noeud insertRec(Noeud root, String data, String password) {
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
    boolean isNodePresent(String data) {
        return containsRec(root, data);
    }

    boolean containsRec(Noeud root, String data) {
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
