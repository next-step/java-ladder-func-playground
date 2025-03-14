package model;

import java.util.Random;

public class ConnectDecider {
    private static final Random random = new Random();

    private final boolean canBeConnected;

    private ConnectDecider(boolean canBeConnected) {
        this.canBeConnected = canBeConnected;
    }

    public static ConnectDecider getRandomConnectDecider() {
        return new ConnectDecider(random.nextBoolean());
    }

    public static ConnectDecider from(boolean connectDecider) {
        return new ConnectDecider(connectDecider);
    }

    public boolean isCanBeConnected() {
        return this.canBeConnected;
    }

}
