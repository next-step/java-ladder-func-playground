package model.ladder;

public enum LadderPoint {
    CONNECTED(true),
    DISCONNECTED(false);

    private final Boolean isConnected;

    LadderPoint(Boolean isConnected) {
        this.isConnected = isConnected;
    }

    public Boolean getConnected() {
        return isConnected;
    }
}
