package domain;

import static domain.Width.MAX_LADDER_WIDTH_SIZE;
import static domain.Width.MIN_LADDER_WIDTH_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    @DisplayName("사다리 넓이가 최소 기준을 준수하지 않았을 시 예외가 발생한다.")
    void shouldThrowException_whenInvalidWidth(int width) {
        // given & when & then
        assertThatThrownBy(() -> Width.from(width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_WIDTH_SIZE, MAX_LADDER_WIDTH_SIZE));
    }
}
