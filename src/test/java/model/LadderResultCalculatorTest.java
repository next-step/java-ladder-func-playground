package model;

import fixture.LadderResultValuesFixture;
import fixture.LadderUsersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultCalculatorTest {

    private static final LadderUsers FOUR_USERS = LadderUsersFixture.FOUR_USERS.getValue();
    private static final LadderUsers FIVE_USERS = LadderUsersFixture.FIVE_USERS.getValue();
    private static final String[] FOUR_RESULTS = LadderResultValuesFixture.FOUR_RESULTS.getValue();
    private static final String[] FIVE_RESULTS = LadderResultValuesFixture.FIVE_RESULTS.getValue();

    @Test
    @DisplayName("사용자 수와 결과 수가 다르면 예외가 발생한다")
    void ifUserAmountDifferentFromResultValuesAmountThanThrowException() {
        assertThatThrownBy(() -> new LadderResultCalculator(FOUR_USERS, FIVE_RESULTS))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LadderResultCalculator(FIVE_USERS, FOUR_RESULTS))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
