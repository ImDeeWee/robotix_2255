import java.util.Scanner;

public class Inscription {
    Scanner scanner = new Scanner(System.in);
    public void insciptionUtilisateur(ArbreCompte arbre){
        while (true) {
            System.out.println("Quelle est votre pseudonyme");
            String pseudonyme = scanner.nextLine();

            if (arbre.isNodePresent(pseudonyme)) {
                System.out.println("Le pseudo "+pseudonyme+" est deja utilise. Veuillez en choisir un nouveau svp");
                continue;
            }
            else{

            }
        }

    }
    public void insciptionFournisseur(ArbreCompte arbe){
        return;
    }
    private void inscriptionInfoNecessaire(){


    }

}
