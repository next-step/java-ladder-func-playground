package domain;

public class Point {
    private final boolean connected;

    private Point(boolean connected) {
        this.connected = connected;
    }

    public static Point of(boolean connected) {
        return new Point(connected);
    }

    public boolean isConnected() {
        return connected;
    }
}
