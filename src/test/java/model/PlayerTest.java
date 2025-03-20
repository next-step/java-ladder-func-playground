package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("유효한 이름으로 플레이어가 정상적으로 생성된다.")
    void shouldCreatePlayerCorrectlyWhenNameIsValid() {
        String validName = "Alice";

        Player player = new Player(validName);

        assertThat(player.getValue()).isEqualTo(validName);
    }

    @Test
    @DisplayName("플레이어 이름이 최대 길이를 초과하면 예외가 발생한다.")
    void shouldThrowExceptionWhenNameMaxLength() {
        String invalidName = "LongName";

        assertThatThrownBy(() -> new Player(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 최대 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어 이름이 null이면 예외가 발생한다.")
    void shouldThrowExceptionWhenNameIsNullOrEmpty(String invalidName) {
        assertThatThrownBy(() -> new Player(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이거나 비어있을 순 없습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", "   "})
    @DisplayName("플레이어 이름이 공백 문자일 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenNameIsBlank(String invalidName) {
        assertThatThrownBy(() -> new Player(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이거나 비어있을 순 없습니다.");
    }
}
