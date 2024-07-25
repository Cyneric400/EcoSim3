package utils;

import java.util.HashMap;

public class Point {
    // Swap these around
    private int xpos;
    private int ypos;

    public Point(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

    public void setCoords(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

    // TODO: NOT TESTED
    public int isGreaterY(Point op) {
        int tX = this.getX();
        int tY = this.getY();
        int oX = op.getX();
        int oY = op.getY();
        if (tX > oX || ((tX == oX) && (tY > oY))) {
            return 1;
        } else if (tX < oX || ((tX == oX) && (tY < oY))) {
            return -1;
        } else {
            return 0;
        }
    }

    // https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        } else {
            Point no = (Point) o;
            return ((this.xpos == no.xpos) && (this.ypos == no.ypos));
        }


    }

    @Override
    public String toString() {
        return String.format("%d, %d", this.xpos, this.ypos);
    }

    public Point move(Direction dir) {
        if (dir == Direction.EAST) {
            return new Point(this.xpos, this.ypos+1);
        } else if (dir == Direction.WEST) {
            return new Point(this.xpos, this.ypos - 1);
        } else if (dir == Direction.NORTH) {
            return new Point(this.xpos-1, this.ypos);
        } else if (dir == Direction.SOUTH) {
            return new Point(this.xpos+1, this.ypos);
        }
        return new Point(this.xpos, this.ypos);
    }

    public int getX() {
        return this.xpos;
    }

    public int getY() {
        return this.ypos;
    }


}
