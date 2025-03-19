package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("레더의 라인이 정상적으로 반환된다.")
    void shouldReturnLinesCorrectly() {

        List<Line> lines = Arrays.asList(new Line(Arrays.asList(Point.HAS_POINT, Point.NO_POINT)),
                new Line(Arrays.asList(Point.NO_POINT, Point.HAS_POINT)));

        Ladder ladder = new Ladder(lines);

        List<Line> result = ladder.getLines();

        assertThat(result).hasSize(2);
        assertThat(result).isEqualTo(lines);
    }

    @Test
    @DisplayName("라인의 포인트 목록이 정상적으로 반환된다.")
    void shouldReturnPointsFromLinesCorrectly() {

        Line line1 = new Line(Arrays.asList(Point.HAS_POINT, Point.NO_POINT));
        Line line2 = new Line(Arrays.asList(Point.NO_POINT, Point.HAS_POINT));
        List<Line> lines = Arrays.asList(line1, line2);
        Ladder ladder = new Ladder(lines);

        List<Point> result = ladder.getPointsFromLines();

        assertThat(result).hasSize(4);
        assertThat(result.get(0)).isEqualTo(Point.HAS_POINT);
        assertThat(result.get(1)).isEqualTo(Point.NO_POINT);
        assertThat(result.get(2)).isEqualTo(Point.NO_POINT);
        assertThat(result.get(3)).isEqualTo(Point.HAS_POINT);
    }
}
