package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    void 높이_테스트() {

        //given
        Height height = Height.from(5);

        //when &then
        assertThrows(IllegalArgumentException.class, () -> Height.from(0));
        assertEquals(5, height.getHeight());
    }
}