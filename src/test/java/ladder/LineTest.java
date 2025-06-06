package ladder;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("라인 생성")
    void generateLine() {
        Line line = Line.create(4);
        List<Boolean> points = line.getPoints();

        assertThat(points).hasSize(3);  // width-1 개 포인트
        assertThat(points)
            .doesNotContainSequence(true, true);  // 연속된 true가 XXX
    }
}
