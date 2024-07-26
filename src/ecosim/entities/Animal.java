package ecosim.entities;

import utils.Direction;

public abstract class Animal extends Entity {
    protected int age;
    protected int energy;

    public Animal(int x, int y) {
        super(x, y);
        this.age = 0;
    }

    // Abstract methods for all Animals
    public abstract void eat();
    public abstract void move();

    // Add in reproduction later
}
