package domain;

public enum Bridge {
    CONNECTED,
    NOT_CONNECTED;

    public String display() {
        if (this == CONNECTED) {
            return "-----";
        }
        return "     ";
    }

    public static Bridge fromBoolean(boolean connected) {
        if (connected) {
            return CONNECTED;
        }
        return NOT_CONNECTED;
    }
}
