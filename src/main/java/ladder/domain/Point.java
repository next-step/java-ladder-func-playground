package ladder.domain;

public enum Point {
    BRIDGE(true),
    EMPTY(false);

    private final boolean hasBridge;

    Point(boolean hasBridge) {
        this.hasBridge = hasBridge;
    }

    public static Point from(boolean hasBridge) {
        return hasBridge ? BRIDGE : EMPTY;
    }

    public boolean hasBridge() { return hasBridge; }
}
