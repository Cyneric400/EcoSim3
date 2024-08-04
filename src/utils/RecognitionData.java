package utils;

import ecosim.entities.Entity;

public class RecognitionData {
    public SquareState entitySees(Entity e) {
        String name = e.getClass().getSimpleName();
        String parentName = e.getClass().getSuperclass().getSimpleName();
        if (parentName.equals("Animal")) {
            return SquareState.OBSTACLE;
        }
        else if (name.equals("NullEntity")) {
            return SquareState.EMPTY;
        }
        else {
            return SquareState.OBSTACLE;
        }
    }
}
