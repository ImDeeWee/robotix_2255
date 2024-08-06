package org.example.Model;
import java.util.ArrayList;

public class Tache {
    private ArrayList<Action> actions;

    public Tache() {
        this.actions = new ArrayList<>();
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void removeAction(Action action) {
        this.actions.remove(action);
    }
}

