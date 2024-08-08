package ecosim;

import ecosim.entities.Animal;
import ecosim.entities.Entity;
import ecosim.entities.Grass;
import ecosim.entities.NullEntity;
import utils.Point;

import java.util.ArrayList;
import java.io.IOException;

public class Ecosystem {
    public int size;
    public int year;
    public ArrayList<Entity> entities;
    private SightSystem sightsys;

    public void addEntities(ArrayList<Entity> starterEntities) {
        starterEntities = sortEntities(starterEntities);
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
                        this.entities.add(new NullEntity(i, j, this));
                    }
                } else {
                    this.entities.add(new NullEntity(i, j, this));
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

    public Ecosystem(int size) throws IllegalStateException {
        moveCursor(1000, 1000);
        System.out.println("hehehehe");
        this.size = size;
        this.entities = new ArrayList<>();
    }

    private static ArrayList<Entity> sortEntities(ArrayList<Entity> ents) {
        ents.sort((e1, e2) -> e1.getCoords().isGreaterY(e2.getCoords()));
        return ents;
    }

    private static void clearScreen() {
        System.out.print("\u001B[32m" + "Hello, world" + "\u001B[0m");
    }

    private static void moveCursor(int x, int y) {
        // System.out.printf("\u001B[%d;%dH", x, y);
        String esc = "\033[" + (x + 1) + ";" + (y + 1) + "H hhhiiii\n\n\nhiii";
        System.out.print(esc);
        // System.out.setCursorPosition(x, y);
    }


    public void printMap() {
        clearScreen();
        moveCursor(20, 20);
        System.out.print("\u001B[34m" + "Hiiii" + "\u001B[0m");
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

    // TODO: Add Javadoc with the possibility of returning null
    public Entity findEntityByCoords(Point coords) {
        // TODO: Make this binary search later
        for (Entity ent : entities) {
            if (ent.getCoords().equals(coords)) {
                return ent;
            }
        }
        // If none found, which is a problem
        NullEntity addedEnt = new NullEntity(coords.getX(), coords.getY(), this);
        this.entities.add(addedEnt);
        return addedEnt;
        // return null;
    }

    public void year() {
        this.year++;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Animal) {
                entities.get(i).live();
                if (!entities.get(i).isAlive()) {
                    entities.set(i, new Grass(entities.get(i).getCoords().getX(), entities.get(i).getCoords().getY(), this));
                }
            }
        }
        // Set up the system for tracking if entities have moved positions and if so interfacing
        // with the observer system
//        // TODO: Change to javadoc
//        this.entities = sortEntities(this.entities);
//        for (Entity e : this.entities) {
//            // sightsys.update(e.getCoords().convInt(), )
//        }
//        boolean entsMoved = false;
//        if (entsMoved) {
//            sightsys.update();
//        }
//        Point[] spacesChanged = // spaces changed

    }
}