package domain;

import static domain.Height.MAX_LADDER_HEIGHT_SIZE;
import static domain.Height.MIN_LADDER_HEIGHT_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    @DisplayName("사다리 높이가 최소 기준을 준수하지 않았을 시 예외가 발생한다.")
    void shouldThrowException_whenInvalidHeight(int height) {
        // given & when & then
        assertThatThrownBy(() -> Height.from(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_HEIGHT_SIZE, MAX_LADDER_HEIGHT_SIZE));
    }
}
