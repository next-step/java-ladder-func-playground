package model.ladder;

public enum ConnectionStatus {
    CONNECTED,
    DISCONNECTED;

    public static ConnectionStatus from(boolean connect) {
        if (connect) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return this == CONNECTED;
    }

}
