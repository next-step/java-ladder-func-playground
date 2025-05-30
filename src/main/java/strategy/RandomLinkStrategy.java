package strategy;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy{
    private final Random random = new Random();

    @Override
    public boolean canLink() {
        return random.nextBoolean();
    }
}
