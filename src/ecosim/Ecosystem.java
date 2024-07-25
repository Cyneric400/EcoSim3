package ecosim;

import ecosim.entities.Entity;
import java.util.ArrayList;
import java.util.Arrays;

public class Ecosystem {
    public int size;
    public ArrayList<Entity> entities;

    public Ecosystem(int size, ArrayList<Entity> starterEntities) {
        this.size = size;
        this.entities = starterEntities;
    }

    private void entitySorter() {

    }
    private void sortEntities() {
        this.entities.sort((e1, e2) -> e1.getCoords().isGreaterY(e2.getCoords()));
    }

    public void printMap() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String mapToPrint = "";
        this.sortEntities();
        int counter = 0;
        for (Entity thing : this.entities) {
            mapToPrint += thing;
            counter++;
            if (counter >= this.size) {
                mapToPrint += "\n";
            }
        }
        return mapToPrint;
    }
}