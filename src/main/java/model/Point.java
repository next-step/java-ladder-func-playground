package model;

public enum Point {
    HAS_POINT(true),
    NO_POINT(false);

    private final boolean point;

    Point(boolean point) {
        this.point = point;
    }
}
