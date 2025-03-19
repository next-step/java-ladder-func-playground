package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class PointGeneratorTest {

    private PointGenerator pointGenerator;
    private Players players;

    @BeforeEach
    void setUp() {
        players = new Players(Arrays.asList("neo", "brown", "brie", "tommy"));
    }

    private void createPointGeneratorWithFixedNumber(int number) {
        pointGenerator = new PointGenerator(new FixedNumberGenerator(number));
    }

    @Test
    @DisplayName("포인트 리스트 크기가 3으로 생성된다.")
    void shouldHaveSizeThree() {
        createPointGeneratorWithFixedNumber(0);
        Size size = new Size(players.size());

        List<Point> points = pointGenerator.createLinePoints(size);

        assertThat(points).hasSize(3);
    }

    @Test
    @DisplayName("고정된 숫자 생성기 값이 0일 때, 모든 포인트가 NO_POINT로 생성된다.")
    void shouldCreateLinePointsAllNoPoint() {
        createPointGeneratorWithFixedNumber(0);
        Size size = new Size(players.size());

        List<Point> points = pointGenerator.createLinePoints(size);

        assertThat(points).allMatch(point -> point == Point.NO_POINT);
    }

    @Test
    @DisplayName("고정된 숫자 생성기 값이 1일 때, HAS_POINT가 포함된 포인트가 생성된다.")
    void shouldCreateLinePointsWithHasPoint() {
        createPointGeneratorWithFixedNumber(1);
        Size size = new Size(players.size());

        List<Point> linePoints = pointGenerator.createLinePoints(size);

        assertThat(linePoints).contains(Point.HAS_POINT);
    }
}
