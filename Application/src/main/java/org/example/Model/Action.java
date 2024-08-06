package org.example.Model;

/**
 * Représente une action avec un type spécifique.
 */
public class Action {
    private ActionType type;

    /**
     * Constructeur pour créer une action avec le type spécifié.
     *
     * @param type Le type de l'action.
     */
    public Action(ActionType type) {
        this.type = type;
    }

    /**
     * Obtient le type de l'action.
     *
     * @return Le type de l'action.
     */
    public ActionType getType() {
        return type;
    }

    /**
     * Définit le type de l'action.
     *
     * @param type Le type de l'action.
     */
    public void setType(ActionType type) {
        this.type = type;
    }

}
