package domain;

public class Point {
    private final boolean  isConnected;

    Point(boolean connected) {
        this.isConnected = connected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
