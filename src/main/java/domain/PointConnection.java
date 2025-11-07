package domain;

public record PointConnection(boolean connected) {
    public boolean isConnected() {
        return connected;
    }
}


