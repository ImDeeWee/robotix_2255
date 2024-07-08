import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ArbreEmail extends ArbreBinaireRecherche{

    class Email extends Noeud{
        ArrayList<Message> messagesList = new ArrayList<>();
        public ArrayList<Message> getMessagesList() {
            return this.messagesList;
        }

        public void setMessagesList(ArrayList<Message> messagesList) {
            this.messagesList = messagesList;
        }



        public Email(String email, String password) {
            super(email, password);
            Message firstMessage = new Message("2105'sSurvivorsEmail","Creation de l'email","L'email a l'adresse courriel "+email+" est maintenue cree",TypeMessage.EmailCreer);
            ArrayList<Message>  firstInbox= new ArrayList<>();
            firstInbox.add(0, firstMessage);

            setMessagesList(firstInbox);
        }
    }

    public Email getNewEmail(String email, String password){
        Email newEmail = new Email(email, password);
        return newEmail;
    }


    public void insert(Email newEmail) {
        root = insert((Email) root, newEmail);
    }
    private Email insert(Email root, Email newEmail){
        if (root == null) {
            root = newEmail;
            size++;
            return root;
        }
        String data = newEmail.getIdentifiant();

        // Sinon, parcourir l'arbre
        if (data.compareTo(root.getIdentifiant()) < 0)
            root.left = insert((Email) root.left, newEmail);
        else if (data.compareTo(root.getIdentifiant()) > 0)
            root.right = insert((Email) root.right, newEmail);

        // Retourner le nœud (non modifié)
        return root;
    }
    public Email getEmail (String email){
        return getEmailRec((Email) root, email);
    }
    private Email getEmailRec(Email root, String email){
        // Si l'arbre est vide ou si on atteint un nœud feuille
        if (root == null || root.getIdentifiant().equals(email)) {
            return root;
        }
        // Sinon, rechercher dans le sous-arbre gauche ou droit
        if (email.compareTo(root.getIdentifiant()) < 0) {
            return getEmailRec((Email) root.left, email);
        } else {
            return getEmailRec((Email) root.right, email);
        }
    }

    public void changeEmail(String data, Email newEmail) {
        root = changeEmailRec(root, data, newEmail);
    }

    // Méthode récursive pour remplacer un nœud existant par un nouveau nœud
    private Email changeEmailRec(Noeud root, String data, Email newNode) {
        // Si l'arbre est vide, retourner null
        if (root == null) {
            return null;
        }

        // Si le nœud à remplacer est trouvé
        if (root.getIdentifiant().equals(data)) {
            newNode.left = root.left;
            newNode.right = root.right;
            return newNode;
        }

        // Sinon, parcourir l'arbre pour trouver le nœud à remplacer
        if (data.compareTo(root.getIdentifiant()) < 0) {
            root.left = changeEmailRec(root.left, data, newNode);
        } else {
            root.right = changeEmailRec(root.right, data, newNode);
        }

        return (Email) root;
    }

    public ArbreCompte getInbox(ArbreEmail.Email userEmail, ArbreCompte arbreCompte){
        Scanner scanner = new Scanner(System.in);
        int listSize = userEmail.messagesList.size();
        boolean inboxFini = false;



        while (!inboxFini){
            System.out.println("Vous etes connecte au courriel de "+userEmail.getIdentifiant()+" . Bienvenue!");
            System.out.println("Voici vos messages. Veuillez choisir le message qui vous voulez lire en selectionnnant le numero correspondant.");
            for (int i = 0; i < listSize;i++){
                System.out.println("["+i+"] "+userEmail.messagesList.get(i).title);
            }
            System.out.println("["+listSize+"] Revenir au menu principal.");

            try{
                int option = scanner.nextInt();                                  //Exception a handle
                scanner.nextLine();

                if (option == listSize){
                    inboxFini = true;
                } else if (option < listSize) {
                    arbreCompte = openMessage(userEmail.messagesList.get(option), arbreCompte);

                }
                else{
                    System.out.println("Veuillez choisir une des options presentees!");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Veuillez choisir une des NUMEROS presentes");
                scanner.nextLine();
            }
        }
        
        
        return arbreCompte;
        
        

    }



    private ArbreCompte openMessage(Message messageAOuvrir, ArbreCompte arbreCompte){
        Scanner scanner = new Scanner(System.in);
        String option;

        System.out.println("Auteur du message: "+messageAOuvrir.auteur);
        System.out.println("Tpe de message: "+messageAOuvrir.messageType);
        System.out.println("Contenue du message: "+messageAOuvrir.contenueMessage);
        System.out.println("Quand vous etes pret a retourner dans votre boite d'inbox, veuillez entrer \"EXIT\".");

         boolean exitMessage = false;

         while (!exitMessage){
             option = scanner.nextLine();

             if (messageAOuvrir.messageType == TypeMessage.ConfirmationInscritpion && Objects.equals(option, "CONFIRMER")){

                 Inscription.NewAccount newAccount = messageAOuvrir.getNewAccount();
                 if (!arbreCompte.isNodePresent(newAccount.getPseudonyme())){
                    arbreCompte.insert(newAccount);
                     System.out.println("Le compte a ete creer");
                     System.out.println("Quand vous etes pret a retourner dans votre boite d'inbox, veuillez entrer \"EXIT\".");
                 }
                 else{
                     System.out.println("Desole, le pseudonyme "+newAccount.getPseudonyme()+" a deja ete utilise. Veuillez creer un nouveau compte avec un autre pseudonyme. :(");

                 }


             }
             else if (Objects.equals(option, "EXIT")) {
                 exitMessage = true;
             }
             else{
                 System.out.println("Essaye meme pas d'ecrire quelque chose d'autre, ca ne marchera pas.");
             }

         }

        

        return arbreCompte;
    }

    


}
