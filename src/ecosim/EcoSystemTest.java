package ecosim;

import ecosim.entities.Entity;
import ecosim.entities.Deer;

import java.util.ArrayList;

public class EcoSystemTest {
    public static void main(String[] args) {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        System.out.println(entities.add(new Deer(4,3)));
        entities.add(new Deer(0,0));
        Ecosystem ecosys = new Ecosystem(1, entities);
        ecosys.printMap();
    }
}


