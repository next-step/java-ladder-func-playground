package test.model;

import org.junit.jupiter.api.Test;

import model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void 이름이_5자를_초과하면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Player("abcdef"));
    }

    @Test
    void 이름이_5자_이하면_통과() {
        Player player = new Player("Neo");
        assertEquals("Neo", player.getName());
    }
}
