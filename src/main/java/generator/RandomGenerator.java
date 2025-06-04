package generator;

import java.util.Random;

public class RandomGenerator implements Generator{
    private final Random random = new Random();

    @Override
    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    @Override
    public int getRandomInt(int bound) { return random.nextInt(bound); }
}
