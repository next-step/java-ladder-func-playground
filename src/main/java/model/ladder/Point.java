package model.ladder;

public class Point {
    private final ConnectionStatus status;

    public Point(ConnectionStatus status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status.isConnected();
    }
}
