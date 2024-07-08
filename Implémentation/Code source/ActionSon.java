public class ActionSon extends Action {
    private String sonDescription;

    public ActionSon(String description, String sonDescription) {
        super(description, TypeAction.SOUND);
        this.sonDescription = sonDescription;
    }

    public String getSonDescription() {
        return sonDescription;
    }

    public void setSonDescription(String sonDescription) {
        this.sonDescription = sonDescription;
    }

}

