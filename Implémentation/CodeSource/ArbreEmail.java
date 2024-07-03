import java.util.ArrayList;

public class ArbreEmail extends ArbreBinaireRecherche{

    class Email extends Noeud{
        public ArrayList<Message> getMessagesList() {
            return messagesList;
        }

        public void setMessagesList(ArrayList<Message> messagesList) {
            this.messagesList = messagesList;
        }

        ArrayList<Message> messagesList = new ArrayList<>();

        public Email(String email, String password) {
            super(email, password);
            setMessagesList(null);
        }
    }


    public void openMessage(Message messageAOuvrir){
        System.out.println("Auteur du message: "+messageAOuvrir.auteur);
        System.out.println("Tpe de message: "+messageAOuvrir.messageType);
        System.out.println("Contenue du message: "+messageAOuvrir.contenueMessage);


    }

}
