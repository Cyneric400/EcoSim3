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

    public Ecosystem(int size, ArrayList<Entity> starterEntities) {
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
                System.out.print(i);
                System.out.print(j);
                try {
                    System.out.println((starterEntities.get(entCount).getCoords().equals(new Point(i, j))));

                    if (starterEntities.get(entCount).getCoords().equals(new Point(i, j))) {
                        this.entities.add(starterEntities.get(entCount));
                        entCount++;
                    } else {
                        this.entities.add(new NullEntity(i, j));
                    }
                } catch (IndexOutOfBoundsException e) {
                    entCount = 0;
                    break;
                }
            }
        }
        this.year = 0;
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

    }
}