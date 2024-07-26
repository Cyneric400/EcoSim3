package ecosim;

import ecosim.entities.Entity;
import ecosim.entities.Deer;

import java.util.ArrayList;

public class EcoSystemTest {
    public static void main(String[] args) {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        System.out.println(entities.add(new Deer(4,3)));
        entities.add(new Deer(0,0));
        entities.add(new Deer(2,2));
        entities.add(new Deer(1,4));
        Ecosystem ecosys = new Ecosystem(10, entities);
        ecosys.printMap();
        ecosys.year();
        ecosys.year();
        ecosys.printMap();
        ecosys.year();
        ecosys.year();
        ecosys.printMap();
    }
}