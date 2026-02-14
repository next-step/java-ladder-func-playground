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
        Line line = Line.generate(size, () -> true);
        Points points = line.getPoints();

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
        Line line = Line.generate(size, () -> false);

        // then
        assertThat(line.getPoints())
            .extracting(Point::hasBridge)
            .containsOnly(false);
    }

    @DisplayName("요청한 사이즈만큼 Point가 생성된다.")
    @Test
    void createLine_SizeCheck() {
        int size = 10;
        Line line = Line.generate(size, () -> true);
        assertThat(line.getPoints()).hasSize(size);
    }

    @DisplayName("다리 유무에 따라 인덱스가 좌, 우로 이동하거나 그대로 유지된다.")
    @Test
    void move() {
        Line line = Line.generate(3, () -> true);

        assertAll(
            // 0번 기둥: 0번 포인트가 T이므로 오른쪽(1)으로 이동
            () -> assertThat(line.move(0)).isEqualTo(1),

            // 1번 기둥: 0번 포인트가 T이므로 왼쪽(0)으로 이동
            () -> assertThat(line.move(1)).isEqualTo(0),

            // 2번 기둥: 2번 포인트가 T이므로 오른쪽(3)으로 이동 (1번 포인트는 F)
            () -> assertThat(line.move(2)).isEqualTo(3),

            // 3번 기둥: 2번 포인트가 T이므로 왼쪽(2)으로 이동
            () -> assertThat(line.move(3)).isEqualTo(2)
        );
    }
}
