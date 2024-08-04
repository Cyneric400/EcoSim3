package ecosim;

import ecosim.entities.Animal;
import ecosim.entities.Entity;
import ecosim.entities.Grass;
import ecosim.entities.NullEntity;
import utils.Point;

import java.util.ArrayList;

public class Ecosystem {
    public int size;
    public int year;
    public ArrayList<Entity> entities;
    private SightSystem sightsys;

    public Ecosystem(int size, ArrayList<Entity> starterEntities) throws IllegalStateException {
        this.size = size;
        this.entities = new ArrayList<>();
        starterEntities = sortEntities(starterEntities);
        for (var ent : starterEntities) {
            System.out.println(ent.getCoords());
        }
        // which entities have already been added
        int entCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // System.out.print(i);
                //System.out.print(j);
                if (entCount < starterEntities.size()) {
                    // System.out.println((starterEntities.get(entCount).getCoords().equals(new Point(i, j))));
                    if (starterEntities.get(entCount).getCoords().equals(new Point(i, j))) {
                        this.entities.add(starterEntities.get(entCount));
                        entCount++;
                    } else {
                        this.entities.add(new NullEntity(i, j));
                    }
                } else {
                    this.entities.add(new NullEntity(i, j));
                }
            }
        }
        this.year = 0;
        if (this.entities.size() != (this.size*this.size)) {
            System.out.print(this.size*this.size);
            System.out.print(" does not equal ");
            System.out.print(this.entities.size());
            throw new IllegalStateException();
        }

        this.sightsys = new SightSystem();
        sightsys.startWatching(0,0, entities.get(1));
        sightsys.startWatching(1,1, entities.get(2));
        sightsys.startWatching(0,0, entities.get(2));
        sightsys.displayWatchers();
    }

    private static ArrayList<Entity> sortEntities(ArrayList<Entity> ents) {
        ents.sort((e1, e2) -> e1.getCoords().isGreaterY(e2.getCoords()));
        return ents;
    }

    public void printMap() {
        String mapToPrint = "";
        this.entities = sortEntities(this.entities);
        int counter = 0;
        for (Entity ent : this.entities) {
            mapToPrint += ent;
            counter++;
            if (counter >= this.size) {
                mapToPrint += "\n";
                counter = 0;
            }
        }
        System.out.println(mapToPrint);
    }

    public void year() {
        this.year++;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Animal) {
                entities.get(i).live();
                if (!entities.get(i).isAlive()) {
                    entities.set(i, new Grass(entities.get(i).getCoords().getX(), entities.get(i).getCoords().getY()));
                }
            }
        }
        // Set up the system for tracking if entities have moved positions and if so interfacing
        // with the observer system
        // TODO: Change to javadoc
        this.entities = sortEntities(this.entities);
        for (Entity e : this.entities) {
            // sightsys.update(e.getCoords().convInt(), )
        }
        boolean entsMoved = false;
        if (entsMoved) {
            sightsys.update();
        }
        Point[] spacesChanged = // spaces changed

    }
}