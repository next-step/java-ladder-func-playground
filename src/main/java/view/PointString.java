package view;

import domain.Point;

public enum PointString {
    CONNECTED(true, "-----"),
    DISCONNECTED(false, "     ");

    private boolean isConnected;
    private String string;

    PointString(boolean isConnected, String string) {
        this.isConnected = isConnected;
        this.string = string;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getString() {
        return string;
    }

    public static PointString getPointString(Point point) {
        if(point.isConnected()) {
            return PointString.CONNECTED;
        }
        return PointString.DISCONNECTED;
    }
}
