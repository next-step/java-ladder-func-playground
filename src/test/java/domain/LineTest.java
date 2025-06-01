package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedLineGenerator;
import strategy.LineGenerator;

class LineTest {

    @Test
    @DisplayName("주어진 넓이에 맞게 포인트를 생성한다.")
    void shouldGeneratePoint_whenGivenWidth() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{true, false, true, false}));
        int width = 4;

        // when
        Line line = generator.generate(width);
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
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{false, false, false, false}));
        int width = 4;

        Line line = generator.generate(width);
        List<Point> points = line.getPoints();

        // when & then
        assertThatThrownBy(() -> points.add(Point.from(true)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
