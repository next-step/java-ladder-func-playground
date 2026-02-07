package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("전략이 항상 true여도 다리는 연속해서 생성되지 않고 건너서 생성된다.")
    @Test
    void createLine_AlwaysTrueStrategy() {
        // given
        int size = 3;
        // when
        Line line = Line.from(size, () -> true);
        List<Point> points = line.getPoints();

        // then
        assertAll(
            () -> assertThat(points.get(0).hasBridge()).isTrue(),
            () -> assertThat(points.get(1).hasBridge()).isFalse(),
            () -> assertThat(points.get(2).hasBridge()).isTrue()
        );
    }

    @DisplayName("전략이 항상 false이면 모든 지점에 다리가 없어야 한다.")
    @Test
    void createLine_AlwaysFalseStrategy() {
        // given
        int size = 5;
        // when
        Line line = Line.from(size, () -> false);

        // then
        assertThat(line.getPoints())
            .extracting(Point::hasBridge)
            .containsOnly(false);
    }

    @DisplayName("요청한 사이즈만큼 Point가 생성된다.")
    @Test
    void createLine_SizeCheck() {
        int size = 10;
        Line line = Line.from(size, () -> true);
        assertThat(line.getPoints()).hasSize(size);
    }

}
