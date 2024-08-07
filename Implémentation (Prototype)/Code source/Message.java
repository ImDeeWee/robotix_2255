
public class Message {


    String auteur;
    String contenueMessage;
    String title;

    TypeMessage messageType;
    Inscription.NewAccount newAccount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Inscription.NewAccount getNewAccount(){
        return newAccount;
    }



    public String getContenueMessage() {
        return contenueMessage;
    }

    public void setContenueMessage(String contenueMessage) {
        this.contenueMessage = contenueMessage;
    }



    Message(String auteur, String title, String contenueMessage, TypeMessage messageType){
        this.auteur = auteur;
        setContenueMessage(contenueMessage);
        this.messageType = messageType;
        this.newAccount = null;
        setTitle(title);

    }
    Message (String contenueMessage, String title, Inscription.NewAccount newAccount){
        this.auteur = "Roboxtix";
        setContenueMessage(contenueMessage);
        this.messageType = TypeMessage.ConfirmationInscritpion;
        this.newAccount = newAccount;
        setTitle(title);
    }


}
