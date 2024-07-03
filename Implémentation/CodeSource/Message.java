public class Message {


    String auteur;
    String contenueMessage;

    TypeMessage messageType;

    Message(String auteur, String contenueMessage, TypeMessage messageType){
        this.auteur = auteur;
        this.contenueMessage = contenueMessage;
        this.messageType = messageType;
    }


}
