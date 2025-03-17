package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class LineTest {

    @Test
    @DisplayName("유효한 포인트들이 주어졌을 때 라인이 포인트들을 포함하는지 검증한다.")
    void shouldContainPointsWhenValidProvided() {
        List<Point> points = List.of(Point.HAS_POINT, Point.NO_POINT);

        Line line = new Line(points);

        assertThat(line.getPointGroups()).containsExactly(Point.HAS_POINT, Point.NO_POINT);
    }

    @Test
    @DisplayName("포인트들이 변경 불가능한 리스트로 반환되는지 검증한다.")
    void shouldReturnUnmodifiableList() {
        List<Point> points = List.of(Point.HAS_POINT, Point.NO_POINT);

        Line line = new Line(points);

        assertThatThrownBy(() -> line.getPointGroups().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("포인트들이 주어졌을 때 순서를 유지하는지 검증한다.")
    void shouldContainPointsInOrder() {
        List<Point> points = List.of(Point.HAS_POINT, Point.NO_POINT);

        Line line = new Line(points);

        assertThat(line.getPointGroups())
                .element(0).isEqualTo(Point.HAS_POINT);

        assertThat(line.getPointGroups())
                .element(1).isEqualTo(Point.NO_POINT);
    }

    @Test
    @DisplayName("하나의 포인트가 주어졌을 때 라인이 올바르게 처리하는지 검증한다.")
    void shouldHandleSinglePoint() {
        List<Point> points = List.of(Point.HAS_POINT);

        Line line = new Line(points);

        assertThat(line.getPointGroups()).containsExactly(Point.HAS_POINT);
    }
}
