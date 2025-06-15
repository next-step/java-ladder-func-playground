package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 빈 값이거나 공백일 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyOrBlank(String value) {
        // given & when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 공백이 아니어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jiyuni", "spiderman", "player2"})
    @DisplayName("이름의 최대 길이를 초과하였을 경우 예외가 발생한다.")
    void shouldThrowException_whenOverMaxLength(String value) {
        // given & when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름으로 예약어를 사용했을 경우 예외가 발생한다.")
    void shouldThrowException_whenUsedReservedWord() {
        // given & when & then
        assertThatThrownBy(() -> new Name("all"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("'all'은 예약어이므로 플레이어의 이름이 아니어야 합니다.");
    }
}
