package domain.dto;

import static domain.dto.RequestLadder.MAX_LADDER_SIZE;
import static domain.dto.RequestLadder.MIN_LADDER_SIZE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RequestLadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    @DisplayName("사다리 넓이가 최소 기준을 준수하지 않았을 시 예외가 발생한다.")
    void shouldThrowException_whenInvalidWidth(int width) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadder(width, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_SIZE, MAX_LADDER_SIZE));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    @DisplayName("사다리 높이가 최소 기준을 준수하지 않았을 시 예외가 발생한다.")
    void shouldThrowException_whenInvalidHeight(int height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadder(3, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_SIZE, MAX_LADDER_SIZE));
    }

    @Test
    @DisplayName("유효한 넓이와 높이를 입력했을 경우 예외가 발생하지 않는다.")
    void shouldCreateRequestLadder_whenValidWidthAndHeight() {
        // given & when & then
        assertThatCode(() -> new RequestLadder(3, 3))
                .doesNotThrowAnyException();
    }
}
