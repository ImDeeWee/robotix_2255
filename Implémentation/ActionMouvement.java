public class ActionMouvement extends Action {
    private int distance;
    private int directionX;
    private int directionY;
    private int directionZ;

    public ActionMouvement(String description, int distance, int directionX, int directionY, int directionZ) {
        super(description, TypeAction.MOVE);
        this.distance = distance;
        this.directionX = directionX;
        this.directionY = directionY;
        this.directionZ = directionZ;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public int getDirectionZ() {
        return directionZ;
    }

    public void setDirectionZ(int directionZ) {
        this.directionZ = directionZ;
    }
}

