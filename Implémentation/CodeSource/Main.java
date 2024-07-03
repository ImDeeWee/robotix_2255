import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArbreCompte reseauSocial = new ArbreCompte();
        int option;




        while (true){

             Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenue chez Robotix, Veuillez choisir l'option voulu:\n1: S'inscrire\n2: Se connecter\n3: Acceder a son courriel");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1){                       // Inscription
                Inscription newInscription = new Inscription();
                System.out.println("Veuillez choisir le type de compte:\n1: Utilisateur\n2: Fournisseur");
                option = scanner.nextInt();
                scanner.nextLine();


                if (option == 1){
                    newInscription.insciptionUtilisateur(reseauSocial);

                } else if (option == 2) {
                    newInscription.insciptionFournisseur(reseauSocial);
                }
                else{
                    return;
                }


            } else if (option == 2) {               // Connexion

            } else if (option == 3) {               // Email

            }
            else{
                System.out.println("Veuillez choisir une des options suivantes!\n");
            }
        }





    }


}
