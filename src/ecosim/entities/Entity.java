package ecosim.entities;
import ecosim.Ecosystem;
import utils.Direction;
import utils.Point;
import utils.SquareState;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Entity {
    protected Point coords;
    // A counter used to set up progressive id numbers. Since it's static, all instances share it.
    private static int counter = 0;
    // A unique ID number for every entity
    protected int id;
    protected boolean living;
    protected static int sightRadius = 1;
    // Bug - cannot see diagonally
    /* TODO: What if this is a HashMap of points to SquareStates like in SightSystem? Agh I need more data in these structures
    I need to have this so that it knows what square number it is, what direction it's in, and what's in that direction.
    So in other words...it has */
    protected Ecosystem ecosystem;

    protected HashMap<Direction, ArrayList<SquareState>> mentalMap;

    public Entity(int x, int y, Ecosystem es) {
        this.living = true;
        // Entities have to have a set of coordinates, even if they don't exist on the map yet.
        this.coords = new Point(x, y);
        this.id = counter;
        // Increment the counter for the next id number.
        counter++;
        // Build a mental map of the surroundings, defaulting to empty squares.
        mentalMap = new HashMap<>();
        for (Direction dir : Direction.values()) {
            mentalMap.put(dir, new ArrayList<>());
            for (int i = 0; i < sightRadius; i++) {
                mentalMap.get(dir).add(SquareState.EMPTY);
            }
        }
        this.ecosystem = es;
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

    public int getId() { return this.id; }

    public void updateSight(int square, SquareState newState) {

    }
}
