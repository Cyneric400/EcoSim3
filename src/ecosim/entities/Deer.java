package ecosim.entities;
import ecosim.Ecosystem;
import utils.*;

public class Deer extends Animal {

    // Should this be an abstract thing?
    //private String foodSource = "Grass";
    private int oldAge = 3;

    public Deer(int x, int y, Ecosystem es) {
        super(x, y, es);
    }

    @Override
    public void live() {
        super.age++;
        // Code for moving
        // Code for dying
        if (this.age > oldAge) {
            this.die();
        }
        this.move();
    }

    @Override
    public void eat() {
        // TODO: Expand
    }

    @Override
    public void die() {
        // TODO: Expand
        // Or should this be outside of the Animal class?
        // Yeah, probably outside of the animal class. Or this.die should call an external kill method.
        this.living = false;
    }

    @Override
    public void move() {
        //TODO: Expand
        lookAround();
        Direction moveDirection = null;
        for (Direction d : Direction.values()) {
            System.out.println(mentalMap.get(d));
            if (mentalMap.get(d) == SquareState.DANGER) {
                moveDirection = DirectionUtils.getOppositeDir(d);
                System.out.print("Danger detected to the ");
                System.out.print(d);
            }
        }
        if (moveDirection == null) {
            moveDirection = Direction.EAST;
        }
            // super.checkMove(moveDirection);
        this.coords = this.coords.move(moveDirection);
    }

    @Override
    public void lookAround() {
        for (var d : Direction.values()) {
            mentalMap.replace(d, RecognitionData.deerSees(ecosystem.findEntityByCoords(this.getCoords().move(d))));
        }
    }
}
