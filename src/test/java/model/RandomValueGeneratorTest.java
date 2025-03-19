package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 2;
    private final RandomValueGenerator generator = new RandomValueGenerator();

    @Test
    @DisplayName("랜덤값이 지정된 범위 안에 생성된다.")
    void testRandomValueGenerator() {
        int randomNumber = generator.generateRandomNumber();

        assertThat(randomNumber).isBetween(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
