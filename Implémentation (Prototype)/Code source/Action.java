public class Action {
    private String description;
    private TypeAction type;
 

    public Action(String description, TypeAction type) {
        this.description = description;
        this.type = type;


    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAction getType() {
        return type;
    }

    public void setType(TypeAction type) {
        this.type = type;
    }



    public enum TypeAction {
        MOVE,
        SOUND,
        SPEAK,
        LISTEN,
        DISPLAY_TEXT,
        DISPLAY_GRAPHIC
    }
}

