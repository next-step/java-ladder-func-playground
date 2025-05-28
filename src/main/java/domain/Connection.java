package domain;

public class Connection {
    private final boolean connectedRight;

    public Connection(boolean connectedRight) {
        this.connectedRight = connectedRight;
    }

    public boolean isConnectedRight() {
        return connectedRight;
    }
}
