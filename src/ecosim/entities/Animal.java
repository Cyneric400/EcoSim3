package ecosim.entities;

import ecosim.Ecosystem;

public abstract class Animal extends Entity {
    protected int age;
    protected int energy;

    public Animal(int x, int y, Ecosystem es) {
        super(x, y, es);
        this.age = 0;
    }

    // Abstract methods for all Animals
    public abstract void eat();
    public abstract void move();

    // Add in reproduction later
}
