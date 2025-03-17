package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PrizeTest {

    @Test
    @DisplayName("유효한 값이면 Prize 객체를 생성하는지 검증한다.")
    public void shouldCreatePrizeWithValidValue() {
        String validValue = "Gold";

        Prize prize = new Prize(validValue);

        assertThat(prize.getValue()).isEqualTo(validValue);
    }

    @Test
    @DisplayName("값이 null이면 예외를 발생시키는지 검증한다.")
    public void shouldThrowExceptionWhenValueIsNull() {
        String invalidValue = null;

        assertThatThrownBy(() -> new Prize(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과는 null이거나 공백일 수는 없습니다.");
    }

    @Test
    @DisplayName("값이 빈 문자열이면 예외를 발생시키는지 검증한다.")
    public void shouldThrowExceptionWhenValueIsEmpty() {
        String invalidValue = "";

        assertThatThrownBy(() -> new Prize(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과는 null이거나 공백일 수는 없습니다.");
    }
}
