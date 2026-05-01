package domain;

import constant.ErrorMessage;
import domain.strategy.BooleanGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    private final static int MIN_HEIGHT = 1;

    @Test
    void 사다리의_높이가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> Ladder.of(2, 0, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LADDER_HEIGHT.getIntFormattedMessage(MIN_HEIGHT));
    }

    @Test
    void 사다리_타기_계산_결과를_올바르게_계산한다() {
        /*
        사다리 시뮬 (width: 3, height: 2)
        1층: [true, false]
        2층: [false, true]

        |--|  |
        |  |--|

        0->2
        1->0
        2->1
         */
        // given
        BooleanGenerator booleanGenerator = new IncrementalBooleanGenerator();
        Ladder ladder = Ladder.of(3, 2, booleanGenerator);
        // when
        List<Integer> results = ladder.getAllResult();
        // then
        assertThat(results).containsExactly(2, 0, 1);
    }

    static class IncrementalBooleanGenerator implements BooleanGenerator {
        private final List<Boolean> values = List.of(true, false);
        private int pointer = 0;

        @Override
        public boolean generate() {
            return values.get((pointer++) % 2);
        }
    }
}
