package domain;

import constant.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLowTest {
    private final static int MIN_WIDTH = 2;

    @Test
    void 사다리의_너비가_2미만_이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LadderLow(1, () -> false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LADDER_WIDTH.getIntFormattedMessage(MIN_WIDTH));
    }

    @Test
    void 오른쪽에_가로줄이_있으면_인덱스가_1_증가한다() {
        // given-when
        LadderLow line = new LadderLow(2, () -> true);
        // then
        assertThat(line.calculateNextPosition(0)).isEqualTo(1);
    }

    @Test
    void 왼쪽에_가로줄이_있으면_인덱스가_1_감소한다() {
        // given-when
        LadderLow line = new LadderLow(2, () -> true);
        // then
        assertThat(line.calculateNextPosition(1)).isEqualTo(0);
    }

    @Test
    void 가로줄이_없으면_제자리에_머문다() {
        // given-when
        LadderLow line = new LadderLow(2, () -> false);
        // then
        assertThat(line.calculateNextPosition(0)).isEqualTo(0);
    }

    @Test
    void 가로줄은_연속해서_생성되지_않는다() {
        // given-when
        LadderLow line = new LadderLow(4, () -> true);
        // then
        assertThat(line.getConnections()).containsExactly(true, false, true);
    }
}
