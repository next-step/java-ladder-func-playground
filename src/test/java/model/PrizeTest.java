package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeTest {

    @Test
    @DisplayName("유효한 값이면 Prize 객체가 생성된다.")
    public void shouldCreatePrizeWithValidValue() {
        String validValue = "Gold";

        Prize prize = new Prize(validValue);

        assertThat(prize.getValue()).isEqualTo(validValue);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("값이 null이면 예외가 발생한다.")
    public void shouldThrowExceptionWhenValueIsNull(String invalidValue) {

        assertThatThrownBy(() -> new Prize(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과는 null이거나 공백일 수는 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("값이 빈 문자열, 공백일 경우 예외가 발생한다.")
    public void shouldThrowExceptionWhenValueIsEmpty(String invalidValue) {
        assertThatThrownBy(() -> new Prize(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과는 null이거나 공백일 수는 없습니다.");
    }
}
