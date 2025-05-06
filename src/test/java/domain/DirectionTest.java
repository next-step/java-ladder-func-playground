package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.Line.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DirectionTest {

    @Test
    @DisplayName("LEFT는 왼쪽 연결이 있을 때만 이동 가능하다")
    void LEFT는_왼쪽_연결이_있을_때만_이동_가능하다() {
        List<Boolean> points = Arrays.asList(CONNECTED, NOT_CONNECTED, CONNECTED);

        assertThat(Direction.LEFT.canMove(points, 1)).isTrue();
        assertThat(Direction.LEFT.canMove(points, 0)).isFalse();
    }

    @Test
    @DisplayName("RIGHT는 오른쪽 연결이 있을 때만 이동 가능하다")
    void RIGHT는_오른쪽_연결이_있을_때만_이동_가능하다() {
        List<Boolean> points = Arrays.asList(CONNECTED, NOT_CONNECTED, CONNECTED);
        assertThat(Direction.RIGHT.canMove(points, 0)).isTrue();
        assertThat(Direction.RIGHT.canMove(points, 1)).isFalse();
    }

    @Test
    @DisplayName("DOWN은 항상 이동 가능하다")
    void DOWN은_항상_이동_가능하다() {
        List<Boolean> points = Arrays.asList(NOT_CONNECTED, NOT_CONNECTED, NOT_CONNECTED);
        assertThat(Direction.DOWN.canMove(points, 0)).isTrue();
        assertThat(Direction.DOWN.canMove(points, 1)).isTrue();
    }

    @Test
    @DisplayName("move()는 각 방향에 맞게 위치를 바꾼다")
    void move는_각_방향에_맞게_위치를_바꾼다() {
        assertThat(Direction.LEFT.move(2)).isEqualTo(1);
        assertThat(Direction.RIGHT.move(1)).isEqualTo(2);
        assertThat(Direction.DOWN.move(0)).isEqualTo(0);
    }
}
