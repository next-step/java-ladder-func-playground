package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointsTest {

    @DisplayName("설정한 크기만큼 포인트 묶음이 생성된다.")
    @Test
    void generate_SizeCheck() {
        int size = 5;
        Points points = Points.generate(size, () -> true);

        assertThat(points.size()).isEqualTo(size);
    }

    @DisplayName("전략이 항상 true여도 다리는 연속해서 생성되지 않는다.")
    @Test
    void generate_NoConsecutiveBridges() {
        // given
        Points points = Points.generate(3, () -> true);

        assertAll(
            () -> assertThat(points.get(0).hasBridge()).isTrue(),
            () -> assertThat(points.get(1).hasBridge()).isFalse(),
            () -> assertThat(points.get(2).hasBridge()).isTrue()
        );
    }

    @DisplayName("현재 위치에 다리가 있으면 오른쪽(index + 1)으로 이동한다.")
    @Test
    void move_Right() {
        // given
        Points points = Points.generate(1, () -> true);

        // when & then
        assertThat(points.move(0)).isEqualTo(1);
    }

    @DisplayName("이전 위치에 다리가 있으면 왼쪽(index - 1)으로 이동한다.")
    @Test
    void move_Left() {
        // given
        Points points = Points.generate(1, () -> true);

        // when & then
        assertThat(points.move(1)).isEqualTo(0);
    }

    @DisplayName("좌우에 다리가 없으면 현재 위치를 유지한다.")
    @Test
    void move_Stay() {
        // given
        Points points = Points.generate(3, () -> false);

        // when & then
        assertAll(
            () -> assertThat(points.move(0)).isEqualTo(0),
            () -> assertThat(points.move(1)).isEqualTo(1),
            () -> assertThat(points.move(2)).isEqualTo(2)
        );
    }
}
