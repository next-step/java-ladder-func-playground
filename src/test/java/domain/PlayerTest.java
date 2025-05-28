package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PlayerTest {

    @Test
    @DisplayName("플레이어 생성자 테스트: 정상")
    void validPlayerTest() {
        // Given
        String name = "brie";

        // When
        Player player = new Player(name);

        // Then
        assertEquals("brie", player.name());
    }

    @Test
    @DisplayName("플레이어 생성자 테스트: 예외")
    void invalidPlayerTest() {
        String tooLongName = "neoneo";
        String blankName = "   ";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Player(tooLongName)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Player(blankName))
        );
    }
}
