package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void 높이_테스트() {
        // given
        int heightNumber = 3;

        // when
        Height.from(heightNumber);

        // then
        Assertions.assertEquals(3, heightNumber);
    }

    @Test
    void 높이_예외처리_테스트() {

        // given
        int heightNumber = -1;

        // when&then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Height.from(heightNumber);
        });
    }
}