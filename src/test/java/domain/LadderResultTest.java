package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void getResult() {
        Line line1 = new Line(List.of(true, false, true));
        Line line2 = new Line(List.of(false, true, false));
        Line line3 = new Line(List.of(true, false, false));
        Line line4 = new Line(List.of(false, true, false));
        Line line5 = new Line(List.of(true, false, true));

        List<Line> lines = List.of(line1, line2, line3, line4, line5);
        Ladder ladder = new Ladder(lines);

        LadderResult ladderResult = new LadderResult(ladder);
        List<Integer> result = ladderResult.getResults();

        assertThat(result).containsExactly(0, 3, 2, 1);
    }
}