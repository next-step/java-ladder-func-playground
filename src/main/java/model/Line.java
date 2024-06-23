package model;

public class Line {

    private final boolean hasPedal;

    public static Line of(boolean hasPoint) {
        return new Line(hasPoint);
    }

    public boolean hasPedal() {
        return hasPedal;
    }

    public Line(boolean hasPedal) {
        this.hasPedal = hasPedal;
    }
}
