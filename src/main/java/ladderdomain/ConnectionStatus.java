package ladderdomain;

public enum ConnectionStatus {
    CONNECTED,
    DISCONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public static ConnectionStatus from(boolean connect) {
        if (connect) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }
}
