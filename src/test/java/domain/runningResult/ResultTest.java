package domain.runningResult;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ResultTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과가 입력되지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyResult(String value) {
        // given & when & then
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 공백이 아니어야 합니다.");
    }
}
