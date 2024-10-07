package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Errors;

class CountOfLaddersTest {

    @ParameterizedTest(name = "사다리의 개수가 {0}개면 예외가 발생한다.")
    @CsvSource({"-1", "0", "-2"})
    @DisplayName("사다리의 개수는 0개 이하일 수 없다.")
    void countOfLaddersValidateTest(int countOfLadders) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new CountOfLadders(countOfLadders))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.LADDERS_MUST_CONTAINS_LEAST_ONE_LADDER);
    }


}
