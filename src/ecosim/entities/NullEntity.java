package ecosim.entities;
import ecosim.Ecosystem;

public class NullEntity extends Entity {
    public NullEntity(int x, int y, Ecosystem es) {
        super(x, y, es);
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
