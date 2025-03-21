package utils;

import java.util.Random;

public class RandomUtil {
    public static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
