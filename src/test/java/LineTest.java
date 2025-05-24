import domain.Line;
import domain.Point;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @RepeatedTest(5)
    void notOverlapping_row() {
        int width = 4;
        Line line = new Line(width, new Random());

        List<Point> points = line.points();
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).hasRightConnection()) {
                assertThat(points.get(i + 1).hasRightConnection()).isFalse();
            }
        }
    }

    @Test
    void lastPointIsNotConnect() {
        Line line = new Line(4, new Random());
        List<Point> points = line.points();

        Point last = points.get(points.size() - 1);
        assertThat(last.hasRightConnection()).isFalse();
    }
}
