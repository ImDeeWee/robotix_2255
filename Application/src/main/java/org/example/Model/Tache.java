package org.example.Model;

import java.util.ArrayList;

/**
 * Cette classe constitue les taches. Ce sont des suites d'Action.
 */
public class Tache {
    private ArrayList<Action> actions;

    /**
     * Constructeur de tache.
     */
    public Tache() {
        this.actions = new ArrayList<>();
    }

    /**
     * Récupérer les actions de la tâche.
     * 
     * @return une liste des actions de la tâche.
     */
    public ArrayList<Action> getActions() {
        return actions;
    }

    /**
     * Modifier la liste d'actions de la tâche.
     * 
     * @param actions la nouvelle liste d'actions.
     */
    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    /**
     * Rajouter un action à la tâche.
     * 
     * @param action l'action à rajouter.
     */
    public void addAction(Action action) {
        this.actions.add(action);
    }

    /**
     * Supprimer l'action de la tâche.
     * 
     * @param action l'action à supprimer.
     */
    public void removeAction(Action action) {
        this.actions.remove(action);
    }
}
