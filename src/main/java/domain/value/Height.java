package domain.value;

import java.util.Random;

public class Height {

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 6;

    private final int value;


    public Height() {
        Random random = new Random();
        this.value = random.nextInt(MIN_VALUE, MAX_VALUE + 1);
    }

    public int getValue() {
        return value;
    }
}
