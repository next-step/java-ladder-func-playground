package generator;

import java.util.Random;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
