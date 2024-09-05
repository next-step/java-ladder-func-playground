package domain.value;

import java.util.Random;
import java.util.stream.IntStream;

public class Height {

    private final int value;

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 6;


    public Height() {
        Random random = new Random();
        this.value =  IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
            .skip(random.nextInt(MAX_VALUE - MIN_VALUE + 1))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int getValue() {
        return value;
    }
}
