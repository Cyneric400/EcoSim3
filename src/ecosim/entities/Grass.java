package ecosim.entities;

public class Grass extends Plant {
    boolean canWalkOver = true;

    public Grass(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return String.format("%6s%3s", "*", "*");
    }

    @Override
    public void live() {
        // TODO Auto-generated method stub
    }

    @Override
    public void die() {
        // TODO Auto-generated method stub
    }

}
