package domain;

public class Point {
    private final boolean hasRightConnection;

    public Point(boolean hasRightConnection) {
        this.hasRightConnection = hasRightConnection;
    }

    public boolean hasRightConnection() {
        return hasRightConnection;
    }

    public String toString() {
        return hasRightConnection ? "|-----" : "|     ";
    }
}
