package model;

import java.util.Random;

public class RandomValueGenerator implements RandomUtil {
    private static final int RANDOM_BOUND = 2;
    private static final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
