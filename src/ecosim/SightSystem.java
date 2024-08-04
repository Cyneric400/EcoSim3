/***
 * An observer pattern class used to inform animals of changes in
 * surrounding squares and giving them the ability to react to their surroundings.
 * A list of entities subscribed to different squares.
 */

package ecosim;

import ecosim.entities.Entity;
import utils.SquareState;

import java.util.ArrayList;
import java.util.HashMap;

public class SightSystem {
    private final HashMap<String, ArrayList<Entity>> entsWatching;

    public SightSystem() {
        this.entsWatching = new HashMap<>();
    }

    public void startWatching(int x, int y, Entity ent) {
        String xy = Integer.toString(x) + Integer.toString(y);
        if (!this.entsWatching.containsKey(xy)) {
            System.out.println("not already here");
            this.entsWatching.put(xy, new ArrayList<>());
        } else {
            System.out.println("already here");
        }
        this.entsWatching.get(xy).add(ent);

    }

    public void displayWatchers() {
        for (String key : this.entsWatching.keySet()) {
            System.out.print(key);
            System.out.print(" is watched by ");
            for (Entity ent : this.entsWatching.get(key)) {
                System.out.print(ent.getClass().getSimpleName());
                System.out.print(ent.getId());
                System.out.print(" and ");
            }
            System.out.println();
        }
    }

    public void stopWatching(int x, int y, Entity ent) {

    }

    public void update(int square, SquareState newState) {
        for (Entity e : this.entsWatching.get(square)) {
            e.updateSight(square, newState);
        }
    }
}
