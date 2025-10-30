// BridgeStep.java
package Model;

import java.util.Random;

public enum BridgeStep {
    NONE(0),  // 다리 없음
    EXIST(1); // 다리 있음

    private final int value;

    BridgeStep(int value) {
        this.value = value;
    }

    public static BridgeStep createRandomStep(Random random) {
        if (random.nextBoolean()) {
            return EXIST;
        }
        return NONE;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
