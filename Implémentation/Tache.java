import java.util.ArrayList;
import java.util.List;

public class Tache {
    private String description;
    private List<Action> actions;
    private boolean isScheduled;
    private String triggerTime;

    public Tache(String description) {
        this.description = description;
        this.actions = new ArrayList<>();
        this.isScheduled = false;
        this.triggerTime = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void removeAction(Action action) {
        this.actions.remove(action);
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }

    public String getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(String triggerTime) {
        this.triggerTime = triggerTime;
    }
}

