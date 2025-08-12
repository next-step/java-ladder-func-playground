package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void 이름이_5자를_초과하면_예외() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Player("abcdef")
        );
        assertEquals("이름은 최대 5글자까지 가능합니다.", exception.getMessage());
    }

    @Test
    void 이름이_5자_이하면_통과() {
        Player player = new Player("Neo");
        assertEquals("Neo", player.getName());
    }
}
