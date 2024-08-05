package ecosim.entities;
import ecosim.Ecosystem;
import utils.Direction;
import utils.Point;
import utils.RecognitionData;
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
    protected static int sightRadius;
    protected int age;
    protected int energy;
    // Bug - cannot see diagonally
    /* TODO: What if this is a HashMap of points to SquareStates like in SightSystem? Agh I need more data in these structures
    I need to have this so that it knows what square number it is, what direction it's in, and what's in that direction.
    So in other words...it has */
    protected Ecosystem ecosystem;

    //protected HashMap<Direction, HashMap<String, SquareState>> mentalMap;
    protected HashMap<Direction, SquareState> mentalMap;

    private void entitySetup(int x, int y, Ecosystem es) {
        this.living = true;
        // Entities have to have a set of coordinates, even if they don't exist on the map yet.
        this.coords = new Point(x, y);
        this.id = counter;
        // Increment the counter for the next id number.
        counter++;
        // Set up a reference to the ecosystem the entity is contained in
        this.ecosystem = es;
        this.age = 0;
    }

    private void initMap() {
        mentalMap = new HashMap<>();
        for (Direction dir : Direction.values()) {
            /* mentalMap.put(dir, new ArrayList<>());
            for (int i = 0; i < sightRadius; i++) {
                mentalMap.get(dir).add(SquareState.EMPTY);
            } */
            mentalMap.put(dir, SquareState.EMPTY);
        }
    }

    public Entity(int x, int y, Ecosystem es) {
        entitySetup(x, y, es);
        // Set the static variable as none was passed in the constructor
        sightRadius = 1;
        // Build a mental map of the surroundings, defaulting to empty squares.
        initMap();
    }

    public Entity(int x, int y, Ecosystem es, int sR) {
        entitySetup(x, y, es);
        sightRadius = sR;
        // Build a mental map of the surroundings, defaulting to empty squares.
        initMap();
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

    public void lookAround() {
        for (var d : Direction.values()) {
            mentalMap.replace(d, RecognitionData.entitySees(ecosystem.findEntityByCoords(this.getCoords().move(d))));
        }
    };

    public boolean isAlive() {
        return living;
    }

    public int getId() { return this.id; }

    public void updateSight(int square, SquareState newState) {
        return;
    }
}
