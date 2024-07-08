import java.util.Stack;

public class InitialisationComptes{

    public ArbreCompte initialisationCompte(ArbreCompte arbreCompte){
        Stack<Inscription.NewAccount> newAccounts = new Stack<>();

        Inscription.NewAccount compte1 = new Inscription.NewAccount("user1", "password1", "Cristiano", "Ronaldo", "cristiano.ronaldo@gmail.com", 1234567890,"Real Madrid" ,TypeCompte.Fournisseur, "back2back2back CL st");

        Inscription.NewAccount compte2 = new Inscription.NewAccount("user2", "password2", "Lionel", "Messi", "lionel.messi@gmail.com", 1234567891,"FC Barcelona",TypeCompte.Fournisseur, "111 Goat st");
        Inscription.NewAccount compte3 = new Inscription.NewAccount("user3", "password3", "Roger", "Federer", "roger.federer@gmail.com", 1234567892, "Tennis Kings", TypeCompte.Fournisseur, "111 DjokovicK");
        Inscription.NewAccount compte4 = new Inscription.NewAccount("user4", "password4", "Serena", "Williams", "serena.williams@gmail.com", 1234567893,"Tennis Queens", TypeCompte.Fournisseur, "111 NobodyIsCloseToMe");
        Inscription.NewAccount compte5 = new Inscription.NewAccount("user5", "password5", "LeBron", "James", "lebron.james@gmail.com", 1234567894,"Father & Son", TypeCompte.Fournisseur, "111 BlockByJames");
        Inscription.NewAccount compte6 = new Inscription.NewAccount("user6", "password6", "Ansu", "Fati", "ansu.fati@gmail.com", 1234567895, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte7 = new Inscription.NewAccount("user7", "password7", "Pedri", "Gonzalez", "pedri.gonzalez@gmail.com", 1234567896, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte8 = new Inscription.NewAccount("user8", "password8", "Gerard", "Pique", "gerard.pique@gmail.com", 1234567897, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte9 = new Inscription.NewAccount("user9", "password9", "Sergio", "Busquets", "sergio.busquets@gmail.com", 1234567898, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte10 = new Inscription.NewAccount("user10", "password10", "Frenkie", "De Jong", "frenkie.dejong@gmail.com", 1234567899, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte11 = new Inscription.NewAccount("user11", "password11", "Curry", "Stephen", "stephen.curry@gsw.com",1234567801, TypeCompte.Utiliisateur );
        Inscription.NewAccount compte12 = new Inscription.NewAccount("user12", "password12", "Hamilton", "Lewis", "lewis.hamilton@f1.com",1234567802, TypeCompte.Utiliisateur);
        Inscription.NewAccount compte13 = new Inscription.NewAccount("user13", "password13", "Lamar", "Kendrick","kdot@rap.us",1234567804, "I Won The Beef", TypeCompte.Utiliisateur, "111 Compton street");
        Inscription.NewAccount compte14 = new Inscription.NewAccount("user14", "password14", "West", "Kanye", "ye@goat.com",1234567805, "Yeezy" ,TypeCompte.Utiliisateur, "111 Chicago");
        Inscription.NewAccount compte15 = new Inscription.NewAccount("user15", "password15", "Von", "King", "serialKiller@no63.com",1134567805, "OBlock", TypeCompte.Utiliisateur,"no63th Oblock st");


        newAccounts.push(compte1);
        newAccounts.push(compte2);
        newAccounts.push(compte3);
        newAccounts.push(compte4);
        newAccounts.push(compte5);
        newAccounts.push(compte6);
        newAccounts.push(compte7);
        newAccounts.push(compte8);
        newAccounts.push(compte9);
        newAccounts.push(compte10);
        newAccounts.push(compte11);
        newAccounts.push(compte12);
        newAccounts.push(compte13);
        newAccounts.push(compte14);
        newAccounts.push(compte15);

        while (!newAccounts.isEmpty()){
            Inscription.NewAccount i = newAccounts.pop();
            arbreCompte.insert(i);
        }


        return arbreCompte;


    }
}