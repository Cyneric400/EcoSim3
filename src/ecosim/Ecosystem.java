package ecosim;

import ecosim.entities.Animal;
import ecosim.entities.Entity;
import ecosim.entities.Grass;
import ecosim.entities.NullEntity;

import java.util.ArrayList;

public class Ecosystem {
    public int size;
    public int year;
    public ArrayList<Entity> entities;

    public Ecosystem(int size, ArrayList<Entity> starterEntities) {
        this.size = size;
        this.entities = new ArrayList<>();
        starterEntities = sortEntities(starterEntities);
        // which entities have already been added
        int entCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((starterEntities.get(entCount).getCoords().getX() == i) && (starterEntities.get(entCount).getCoords().getY() == j)) {
                    this.entities.add(starterEntities.get(entCount));
                } else {
                    System.out.println("success");
                    this.entities.add(new NullEntity(i, j));
                }
            }
        }
        this.entities = starterEntities;
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
            if (ent instanceof NullEntity) {
                System.out.println("found a null");
            }
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