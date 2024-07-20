package domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBooleanGenerator {

    public Boolean generateRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
