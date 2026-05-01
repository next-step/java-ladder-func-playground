package domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    void 정상적인_사다리를_실행하면_계산된_결과를_반환한다() {
        // given
        Line line1 = new Line(List.of(true, false));  // 0-1 연결
        Line line2 = new Line(List.of(false, true));  // 1-2 연결
        Ladder ladder = new Ladder(List.of(line1, line2));
        LadderWidth width = new LadderWidth(3);

        // when
        LadderResult result = ladder.play(width);

        // then
        assertThat(result.getEndPosition(new Position(0))).isEqualTo(new Position(2));
        assertThat(result.getEndPosition(new Position(1))).isEqualTo(new Position(0));
        assertThat(result.getEndPosition(new Position(2))).isEqualTo(new Position(1));
    }
}
