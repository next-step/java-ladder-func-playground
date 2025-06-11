package result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    @Test
    @DisplayName("실행 결과가 null이면 예외가 발생한다")
    void throwsExceptionWhenValueIsNull() {
        assertThatThrownBy(() -> Prize.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과는 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("실행 결과가 빈 문자열 또는 공백만 있으면 예외가 발생한다")
    void throwsExceptionWhenValueIsBlank() {
        assertThatThrownBy(() -> Prize.from(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과는 비어 있을 수 없습니다.");

        assertThatThrownBy(() -> Prize.from("    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과는 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("정상적으로 생성된 Prize는 값을 가진다")
    void createPrizeSuccessfully() {
        Prize prize = Prize.from("5000");
        assertThat(prize.value()).isEqualTo("5000");
    }
}
