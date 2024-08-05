package utils;

import java.util.HashMap;

public class DirectionUtils {
    // private static HashMap<Direction, Direction> opposites = new HashMap<>();

    public static Direction getOppositeDir(Direction d) {
        if (d == Direction.NORTH) {
            return Direction.SOUTH;
        } else if (d == Direction.SOUTH) {
            return Direction.NORTH;
        } else if (d == Direction.WEST) {
            return Direction.EAST;
        } else if (d == Direction.EAST) {
            return Direction.WEST;
        }
        return Direction.NONE;
    }
}
