package domain;

public class PointConnection {
    private final ConnectionStatus status;

    public PointConnection(ConnectionStatus status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status == ConnectionStatus.CONNECTED;
    }
}
