package domain.ladder;

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
                .extracting(Point::isConnectRight)
                .containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("특정 위치에 연결이 있는지 확인한다.")
    void shouldCheckCorrectConnection() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{true, false, true}));
        Line line = generator.generate(3);

        // when & then
        assertThat(line.hasConnectionAt(0)).isTrue();
        assertThat(line.hasConnectionAt(1)).isFalse();
        assertThat(line.hasConnectionAt(2)).isTrue();
    }

    @Test
    @DisplayName("특정 위치에서 이동 방향을 올바르게 반환한다.")
    void shouldReturnCorrectDirection() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{true, false, true, false}));
        Line line = generator.generate(4);

        // when & then
        assertThat(line.directionAt(0)).isEqualTo(Direction.RIGHT);
        assertThat(line.directionAt(1)).isEqualTo(Direction.LEFT);
        assertThat(line.directionAt(2)).isEqualTo(Direction.RIGHT);
        assertThat(line.directionAt(3)).isEqualTo(Direction.LEFT);
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
