package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Height;
import domain.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RequestLadderTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 넓이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyWidth(String width) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadder(width, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이를 입력해야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 높이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyHeight(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadder("3", height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "3ab"})
    @DisplayName("사다리의 넓이가 숫자가 아닌 경우 예외가 발생한다.")
    void shouldThrowException_whenNoNumericalWidth(String width) {
        // given
        RequestLadder requestLadder = new RequestLadder(width, "3");

        // when & then
        assertThatThrownBy(requestLadder::toWidth)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bb", "3cd"})
    @DisplayName("사다리의 높이가 숫자가 아닌 경우 예외가 발생한다.")
    void shouldThrowException_whenNoNumericalHeight(String height) {
        // given
        RequestLadder requestLadder = new RequestLadder("3", height);

        // when & then
        assertThatThrownBy(requestLadder::toHeight)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("유효한 넓이와 높이를 입력하면 올바르게 객체가 생성된다.")
    void shouldReturnCorrectWidthAndHeight() {
        // given
        RequestLadder requestLadder = new RequestLadder("5", "7");

        // when
        Width width = requestLadder.toWidth();
        Height height = requestLadder.toHeight();

        // then
        assertThat(width.value()).isEqualTo(5);
        assertThat(height.value()).isEqualTo(7);
    }
}
