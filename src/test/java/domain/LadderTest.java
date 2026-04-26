package domain;

import generator.TestConnectionGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {
    private static final int LADDER_WIDTH = 4;
    private static final int LADDER_HEIGHT = 3;
    private static final int START_POSITION = 0;
    private static final int EXPECTED_END_POSITION = 1;
    private static final List<Boolean> TFT_ROW = List.of(
            true, false, true,
            true, false, true,
            true, false, true
    );

    @Test
    void 사다리의_높이는_1이상이다() {
        assertThatThrownBy(() -> Ladder.of(LADDER_WIDTH, 0, new TestConnectionGenerator(TFT_ROW)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_높이만큼_사다리_행이_생성된다() {
        Ladder ladder = Ladder.of(LADDER_WIDTH, LADDER_HEIGHT, new TestConnectionGenerator(TFT_ROW));

        assertThat(ladder.toBooleanLists()).hasSize(LADDER_HEIGHT);
    }

    @Test
    void 사다리는_여러_Row를_위에서_아래로_순서대로_적용한다() {
        Ladder ladder = Ladder.of(LADDER_WIDTH, LADDER_HEIGHT, new TestConnectionGenerator(TFT_ROW));
        int endPosition = ladder.rideLadder(START_POSITION);
        assertThat(endPosition).isEqualTo(EXPECTED_END_POSITION);
    }
}
