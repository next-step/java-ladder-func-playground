package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("포인트 기준 오른쪽의 여부를 받아 객체를 정상적으로 생성한다.")
    void shouldCreatePoint_whenFromRightStatus() {
        // given
        boolean isRightTrue = true;
        boolean isRightFalse = false;

        // when
        Point truePoint = Point.from(isRightTrue);
        Point falsePoint = Point.from(isRightFalse);

        // then
        assertThat(truePoint.right()).isTrue();
        assertThat(falsePoint.right()).isFalse();
    }

    @Test
    @DisplayName("포인트는 가로로 연속되지 않는다.")
    void shouldReturnNextPointFalse_whenPointRightTrue() {
        // given
        Point point = Point.from(true);

        // when
        Point next = point.connectNext(true);

        // then
        assertThat(next.right()).isFalse();
    }

    @Test
    @DisplayName("현재 포인트가 연결되지 않은 경우, 다음 포인트는 입력에 따라 연결된다.")
    void shouldReturnNextPointTrueOrFalse_whenPointRightFalse() {
        // given
        Point point = Point.from(false);

        // when
        Point nextTrue = point.connectNext(true);
        Point nextFalse = point.connectNext(false);

        // then
        assertThat(nextTrue.right()).isTrue();
        assertThat(nextFalse.right()).isFalse();
    }
}
