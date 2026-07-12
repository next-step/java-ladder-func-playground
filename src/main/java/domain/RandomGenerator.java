package domain;

import java.util.Random;

public class RandomGenerator implements RandomStrategy {

    private final Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public RandomGenerator(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }
}
