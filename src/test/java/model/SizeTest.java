package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SizeTest {

    @Test
    @DisplayName("사다리 크기가 유효한 값이면 정상적으로 객체를 생성한다.")
    public void shouldCreateSizeWithValidValue() {
        int validSize = 5;
        Size size = new Size(validSize);
        assertThat(size.getSize()).isEqualTo(validSize);
    }

    @Test
    @DisplayName("사다리 크기가 유효하지 않는 값이면 예외가 발생한다.")
    public void shouldThrowExceptionWhenSizeIsNegative() {
        int invalidSize = -1;

        assertThatThrownBy(() -> new Size(invalidSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 사이즈가 0보다 작을 수는 없습니다.");
    }
}
