package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedGenerator;
import strategy.PointGenerator;

class LineTest {

    @Test
    @DisplayName("주어진 넓이에 맞게 포인트를 생성한다.")
    void shouldGeneratePoint_whenGivenWidth() {
        // given
        PointGenerator generator = new FixedGenerator(new boolean[]{true, false, true, false});
        int width = 4;

        // when
        Line line = Line.create(width, generator);
        List<Point> points = line.getPoints();

        // then
        assertThat(points)
                .extracting(Point::right)
                .containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        PointGenerator generator = new FixedGenerator(new boolean[]{false, false, false, false});
        int width = 4;

        Line line = Line.create(width, generator);
        List<Point> points = line.getPoints();

        // when & then
        assertThatThrownBy(() -> points.add(Point.first(true)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
