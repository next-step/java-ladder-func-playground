package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리의_올바른_최종_인덱스를_반환한다() {
        List<Boolean> connectionsLine1 = Arrays.asList(true, false);
        List<Boolean> connectionsLine2 = Arrays.asList(false, true);

        Line line1 = new Line(connectionsLine1);
        Line line2 = new Line(connectionsLine2);

        Ladder ladder = new Ladder(new Height(2), Arrays.asList(line1, line2));

        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
    }
}
