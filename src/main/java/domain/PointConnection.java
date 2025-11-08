package domain;

public record PointConnection(ConnectionStatus status) {
    public boolean isConnected() {
        return status == ConnectionStatus.CONNECTED;
    }

    public ConnectionStatus getStatus() {
        return status;
    }
}
