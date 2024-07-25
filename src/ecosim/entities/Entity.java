package ecosim.entities;
import utils.Point;

public abstract class Entity {
    protected Point coords;
    // A counter used to set up progressive id numbers. Since it's static, all instances share it.
    private static int counter = 0;
    // A unique ID number for every entity
    protected int id;
    protected boolean living;

    public Entity(int x, int y) {
        this.living = true;
        // Entities have to have a set of coordinates, even if they don't exist on the map yet.
        this.coords = new Point(x, y);
        this.id = counter;
        // Increment the counter for the next id number.
        counter++;
    }

    /***
     * @return a Point object containing the coordinates of the entity.
     */
    public Point getCoords() {
        return this.coords;
    }

    /***
     * @return A string representation of the entity.
     */
    @Override
    // Put this as a superclass method of Entity
    public String toString() {
        return String.format("%6s%3d", this.getClass().getSimpleName(), this.id);
    }

    public abstract void live();
    public abstract void die();

    public boolean isAlive() {
        return living;
    }
}
