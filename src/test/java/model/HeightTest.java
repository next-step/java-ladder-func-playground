package model;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

=======
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

>>>>>>> 0c46fef (Feat:)
class HeightTest {

    @Test
    void 높이_테스트() {
<<<<<<< HEAD

        //given
        Height height = Height.from(5);

        //when &then
        assertThrows(IllegalArgumentException.class, () -> Height.from(0));
        assertEquals(5, height.getHeight());
    }

    @Test
    void 예외처리_테스트() {

        // given
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            Height.from(0);
        });

        // when&then
        assertEquals("예외 처리",exception.getMessage());
=======
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
>>>>>>> 0c46fef (Feat:)
    }
}