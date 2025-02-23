package domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random rand = new Random();

    @Override
    public Boolean nextBoolean() {
        return rand.nextBoolean();
    }
}
