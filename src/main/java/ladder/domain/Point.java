package ladder.domain;

public class Point {

    private static final Point BRIDGE = new Point(true);
    private static final Point EMPTY = new Point(false);

    private final boolean hasBridge;

    private Point(boolean hasBridge) {
        this.hasBridge = hasBridge;
    }

    public static Point from(boolean hasBridge) {
        if (hasBridge) {
            return BRIDGE;
        }
        return EMPTY;
    }

    public boolean hasBridge() {
        return hasBridge;
    }
}
