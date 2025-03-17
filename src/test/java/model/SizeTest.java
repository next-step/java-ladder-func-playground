package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SizeTest {

    @Test
    @DisplayName("사이즈가 유효한 값이면 Size 객체를 생성하는지 검증한다.")
    public void shouldCreateSizeWithValidValue() {
        int validSize = 5;
        Size size = new Size(validSize);
        assertThat(size.getSize()).isEqualTo(validSize);
    }

    @Test
    @DisplayName("사이즈가 유효하지 않는 값이면 예외를 발생시키는지 검증한다.")
    public void shouldThrowExceptionWhenSizeIsNegative() {
        int invalidSize = -1;

        assertThatThrownBy(() -> new Size(invalidSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 사이즈가 0보다 작을 수는 없습니다.");
    }
}
