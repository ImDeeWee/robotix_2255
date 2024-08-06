import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Inscription {

    public static class  NewAccount {
        private String pseudonyme;
        private String prenom;
        private String nom;
        private String compagnie;
        private String password;
        private String email;
        private TypeCompte accountType;
        private Integer phoneNumber;


        private String adresse;
        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getPseudonyme() {
            return pseudonyme;
        }

        public void setPseudonyme(String pseudonyme) {
            this.pseudonyme = pseudonyme;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getCompagnie() {
            return compagnie;
        }

        public void setCompagnie(String compagnie) {
            this.compagnie = compagnie;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public TypeCompte getAccountType() {
            return accountType;
        }

        public void setAccountType(TypeCompte accountType) {
            this.accountType = accountType;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public NewAccount(String pseudo, String password, String nom, String prenom, String courriel, int phone, String compagnie, TypeCompte accountType, String adresse){
            setPseudonyme(pseudo);
            setPassword(password);
            setNom(nom);
            setPrenom(prenom);
            setEmail(courriel);
            setPhoneNumber(phone);
            setCompagnie(compagnie);
            setAccountType(accountType);
            setAdresse(adresse);

        }
        public NewAccount(String pseudo, String password, String nom, String prenom, String courriel, int phone, TypeCompte accountType){
            setPseudonyme(pseudo);
            setPassword(password);
            setNom(nom);
            setPrenom(prenom);
            setEmail(courriel);
            setPhoneNumber(phone);
            setCompagnie(null);
            setAccountType(accountType);

        }


    }

    Scanner scanner = new Scanner(System.in);
    String pseudonyme;
    String adresse;
    String prenom;
    String nom;
    String compagnie;
    String password;
    String email;
    TypeCompte accountType;
    int phoneNumber;
    public ArbreEmail insciptionUtilisateur(ArbreCompte arbre, ArbreEmail emails){
        accountType = TypeCompte.Utiliisateur;
        while (true) {
            System.out.println("Quelle est votre pseudonyme?");
            pseudonyme = scanner.nextLine();

            if (arbre.isNodePresent(pseudonyme)) {
                System.out.println("Le pseudo "+pseudonyme+" est deja utilise. Veuillez en choisir un nouveau svp");
                continue;
            }
            else{
                System.out.println("Quelle est votre prenom?");
                prenom = scanner.nextLine();
                System.out.println("Quelle est votre nom?");
                nom = scanner.nextLine();

                inscriptionInfoNecessaire();


                while (true) {

                    try {
                        System.out.println("Est-ce que vous avez une compagnie?");
                        System.out.println("1: Oui");
                        System.out.println("2: Non");



                        int compagnieOption = scanner.nextInt();                            //Exception a handle
                        scanner.nextLine();

                        if (compagnieOption == 2) {                                     //Utilisateur sans compagnie.
                            NewAccount newAccount = new NewAccount(pseudonyme, password, nom, prenom, email, phoneNumber,accountType);
                            return sendEmailConfirmation(emails, newAccount);



                        }
                        else if (compagnieOption == 1) { //Utilisateur sans compagnie
                            System.out.println("Quelle est le nom de votre compagnie?");
                            compagnie = scanner.nextLine();
                            NewAccount newAccount = new NewAccount(pseudonyme, password, nom, prenom, email, phoneNumber, compagnie, accountType,null);
                            return sendEmailConfirmation(emails, newAccount);


                        }
                        else {
                            System.out.println("Veuillez choisir une des options presentees!");

                        }
                    }
                    catch (InputMismatchException e){
                        intHandle();
                        scanner.nextLine();
                    }
                }

            }
        }

    }
    public ArbreEmail insciptionFournisseur(ArbreCompte arbre, ArbreEmail emails){
        accountType = TypeCompte.Fournisseur;
        System.out.println("Est-ce que vous possedez une compagnie");
        System.out.println("1: Oui");
        System.out.println("2: Non");
        int compagnieOption = scanner.nextInt();                        //handle
        scanner.nextLine();


        if (compagnieOption == 2){
            System.out.println("Vous ne pouvez pas faire un compte fournisseur. Essayer plutot de vous inscrire en tant qu'utilisateur");
        } else if (compagnieOption == 1) {
            while (true){
                System.out.println("Quelle est le nom de votre compagnie?");
                compagnie = scanner.nextLine();                                     // Dans ce contexte, le nom du fournisseur et la compagnie sont pareilles.

                if (!arbre.isNodePresent(compagnie)){
                    System.out.println("Veuillez entrer votre adresse.");
                    adresse = scanner.nextLine();
                    inscriptionInfoNecessaire();
                    NewAccount newAccount = new NewAccount(compagnie, password,"null","null" ,email, phoneNumber, compagnie, TypeCompte.Fournisseur, adresse);
                    return sendEmailConfirmation(emails, newAccount);

                }
                else{
                    System.out.println("La compagnie que vous venez d'entrer est deja dans le systeme :(. Voulez-vous reessayer un autre nom de compagnie ou retourner au menu princpal? ");
                    System.out.println("1: Reessayer");
                    System.out.println("2: Retourner au menu prinicipal.");
                    compagnieOption = scanner.nextInt();                            //handle
                    if (compagnieOption == 1){
                        continue;

                    } else if (compagnieOption == 2) {
                        return emails;
                    }
                    else{
                        System.out.println("Veuillez choisir une des options presentees!");
                    }

                }
            }
        }
        else {
            System.out.println("Veuillez choisir une des options presentees!");
        }
        if (compagnieOption == 1){}

        return emails;
    }
    private void inscriptionInfoNecessaire(){

        System.out.println("Rentrer votre adresse courriel");
        email = scanner.nextLine();
        boolean phoneNumberRentrer = false;
        while (!phoneNumberRentrer){
            System.out.println("Rentrer votre numero de telephone");

            try {
                phoneNumber = Integer.parseInt(scanner.nextLine());                            //Exception a handle et a mettre en INTEGER


                phoneNumberRentrer = true;
            }
            catch (NumberFormatException e){
                System.out.println("Pour le prototype, veuillez choisir un petit numero de telephone svp.");

            }
        }





        while (true){
            System.out.println("Rentrer votre mot de passe");
            String possiblePassword = scanner.nextLine();
            System.out.println("Reconfirmer votre mot de passe");
            String verificationPassword = scanner.nextLine();


            if (!Objects.equals(possiblePassword, verificationPassword)){
                System.out.println("Assurez vous que les deux entree sont identiques");
                continue;
            }
            else{
                password = possiblePassword;
                return;
            }

        }


    }

    public ArbreEmail sendEmailConfirmation(ArbreEmail arbreEmail, NewAccount userToSendEmail){
        ArbreEmail.Email newEmailUser = null;
        boolean emailToAdd = false;

        if (!arbreEmail.isNodePresent(userToSendEmail.email)){
            boolean mdpCree = false;
            while (!mdpCree) {
                emailToAdd = true;
                System.out.println("L'email choisie pour le compte n'existe actuellement pas. Veuillez creer le mot de passe de votre email: ");
                String password = scanner.next();
                System.out.println("Reconfirmer votre mot de passe: ");
                String verificationPassword = scanner.next();


                if (!Objects.equals(password, verificationPassword)){
                    System.out.println("Assurez vous que les deux entree sont identiques");
                    continue;
                }
                else{
                    newEmailUser = arbreEmail.getNewEmail(userToSendEmail.getEmail(), password);
                    mdpCree = true;
                }
            }
        }
        else{
            newEmailUser = arbreEmail.getEmail(userToSendEmail.getEmail());
        }






        String message = "Bienvenue chez Robotix "+userToSendEmail.pseudonyme+". Pour confirmez votre inscription, Veuillez choisir l'option \"CONFIRMER\"." ; // Le message d'inscription

        Message messageInscription = new Message(message,"Confirmation de l'inscription chez Robotix.",userToSendEmail); //Creation de l'objet Message pour le rajouter dans l'email de l'utilisateur

        ArrayList<Message> newMessageList= newEmailUser.getMessagesList();              // get la liste de message de l'utilisateur pour rajouter le message d'inscription

        newMessageList.add(0, messageInscription);

        newEmailUser.setMessagesList(newMessageList);                                   // Changement de la liste de message avec le nouveau message.

        if (emailToAdd){
            arbreEmail.insert(newEmailUser);
        }
        else{
            arbreEmail.changeEmail(newEmailUser.getIdentifiant(), newEmailUser);
        }


        return arbreEmail;







    }

    private void intHandle(){
        System.out.println("Veuillez choisir un des chiffres presente.");
    }

}
