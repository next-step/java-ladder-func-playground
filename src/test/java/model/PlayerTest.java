package model;

import exception.ErrorMessage;
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
        assertEquals(ErrorMessage.LIMIT_NAME_LENGTH, exception.getMessage());
    }

    @Test
    void 이름이_5자_이하면_통과() {
        Player player = new Player("Neo");
        assertEquals("Neo", player.getName());
    }
}
