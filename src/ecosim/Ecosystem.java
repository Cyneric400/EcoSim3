package ecosim;

import ecosim.entities.Entity;
import java.util.ArrayList;

public class Ecosystem {
    public ArrayList<Entity> entities;
    public Ecosystem(ArrayList<Entity> starterEntities) {
        this.entities = starterEntities;
    }
}