package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class HeightTest {

    @Test
    @DisplayName("높이가 유효한 값일 때 정상적으로 생성된다.")
    void shouldCreateHeightWithValidValue() {
        Height height = new Height(5);
        assertThat(height.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("최소값일 때 높이가 정상적으로 생성된다")
    void shouldCreateHeightWithMinimumValue() {
        Height height = new Height(2);
        assertThat(height.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("높이가 2 미만일 때 예외가 발생한다.")
    void shouldThrowExceptionForHeightBelowMin() {
        assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 2 이상이어야 합니다.");
    }
}
