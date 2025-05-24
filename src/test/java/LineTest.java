package domain;

import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @RepeatedTest(10)
    void lineIsWidthPlusOne() {
        int width = 4;
        Line line = Line.create(width);
        assertThat(line.getPoints()).hasSize(width);
    }

    @RepeatedTest(10)
    void notOverlapping() {
        Line line = Line.create(5);
        boolean previous = false;
        for (Point point : line.getPoints()) {
            if (previous && point.isConnected()) {
                throw new AssertionError("인접한 연결이 발견됨");
            }
            previous = point.isConnected();
        }
    }
}
