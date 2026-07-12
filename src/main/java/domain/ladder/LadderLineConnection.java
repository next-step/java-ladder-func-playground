package domain.ladder;

import java.util.Arrays;

public enum LadderLineConnection {

    CONNECT_LADDER("|-----", true),
    NOT_CONNECT_LADDER("|     ", false);

    LadderLineConnection(final String ladderConnectionFormat, final boolean isConnected) {
        this.ladderConnectionFormat = ladderConnectionFormat;
        this.isConnected = isConnected;
    }

    private final String ladderConnectionFormat;
    private final boolean isConnected;

    public String getLadderConnectionFormat() {
        return ladderConnectionFormat;
    }

    public static LadderLineConnection of(final boolean isConnected) {
        if (isConnected) {
            return CONNECT_LADDER;
        }
        return NOT_CONNECT_LADDER;
    }
}
