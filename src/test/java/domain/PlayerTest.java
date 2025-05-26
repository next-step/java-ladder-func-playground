package domain;

import static domain.Player.ERROR_EMPTY_NAME;
import static domain.Player.ERROR_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름은 5글자를 넘을 수 없다")
    @Test
    void invalidNameTest() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_LENGTH);
    }

    @DisplayName("이름은 비어있을 수 없다")
    @Test
    void emptyNameTest() {
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_NAME);
    }
}