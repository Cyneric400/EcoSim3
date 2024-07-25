package utils;

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

    public Point moveEast() {
        return new Point(this.xpos, this.ypos+1);
    }

    public int getX() {
        return this.xpos;
    }

    public int getY() {
        return this.ypos;
    }


}
