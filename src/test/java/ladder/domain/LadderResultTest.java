package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

    @DisplayName("1자 이상 5자 이하의 결과는 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "pass", "abcde"})
    void create_Success(String input) {
        LadderResult result = LadderResult.from(input);
        assertThat(result.getValue()).isEqualTo(input);
    }

    @DisplayName("결과 값 앞뒤에 공백이 있을 경우 제거한다.")
    @Test
    void create_Trim() {
        LadderResult result = LadderResult.from("  꽝  ");
        assertThat(result.getValue()).isEqualTo("꽝");
    }

    @DisplayName("결과가 빈 값일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void create_Blank_Exception(String input) {
        assertThatThrownBy(() -> LadderResult.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("실행 결과는 빈 값일 수 없습니다.");
    }

    @DisplayName("결과가 5자를 초과하면 예외가 발생한다.")
    @Test
    void create_OverLength_Exception() {
        assertThatThrownBy(() -> LadderResult.from("sixchar"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("실행 결과는 최대 5글자입니다.");
    }
}
