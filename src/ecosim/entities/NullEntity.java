package ecosim.entities;

public class NullEntity extends Entity {
    public NullEntity(int x, int y) {
        super(x, y);
    }

    @Override
    public void live() {
        return;
    }

    @Override
    public void die() {
        return;
    }

    @Override
    public String toString() {
        return String.format("%6s%3s", "-", "-");
    }
}
