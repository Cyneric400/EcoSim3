package ecosim;

import ecosim.entities.Cougar;
import ecosim.entities.Entity;
import ecosim.entities.Deer;

import java.util.ArrayList;

public class EcoSystemTest {
    public static void main(String[] args) {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        Ecosystem ecosys = new Ecosystem(10);
        System.out.println(entities.add(new Deer(4,3, ecosys)));
        entities.add(new Deer(0,0, ecosys));
        entities.add(new Deer(2,2, ecosys));
        entities.add(new Deer(1,4, ecosys));
        entities.add(new Cougar(2, 3, ecosys));
        ecosys.addEntities(entities);
        ecosys.printMap();
        ecosys.year();
//        ecosys.year();
//        ecosys.printMap();
//        ecosys.year();
//        ecosys.year();
        ecosys.printMap();
    }
}