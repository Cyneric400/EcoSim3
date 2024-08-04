package ecosim.entities;

import ecosim.Ecosystem;

public abstract class Animal extends Entity {

    public Animal(int x, int y, Ecosystem es) {
        super(x, y, es);
    }

    public Animal(int x, int y, Ecosystem es, int sR) {
        super(x, y, es, sR);
    }

    // Abstract methods for all Animals
    public abstract void eat();
    public abstract void move();
    // public abstract void lookAround();

    // Add in reproduction later
}
