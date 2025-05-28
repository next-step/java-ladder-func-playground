package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("포인트 기준 오른쪽의 여부를 받아 객체를 정상적으로 생성한다.")
    void shouldCreatePoint_whenFirstRightStatus() {
        // given
        boolean isRightTrue = true;
        boolean isRightFalse = false;

        // when
        Point truePoint = Point.first(isRightTrue);
        Point falsePoint = Point.first(isRightFalse);

        // then
        assertThat(truePoint.right()).isTrue();
        assertThat(falsePoint.right()).isFalse();
    }

    @Test
    @DisplayName("포인트의 오른쪽이 ture라면, 다음 포인트는 오른쪽이 false를 가진다.")
    void shouldReturnNextPointFalse_whenPointRightTrue() {
        // given
        Point point = new Point(true);

        // when
        Point next = point.connectNext(true);

        // then
        assertThat(next.right()).isFalse();
    }

    @Test
    @DisplayName("포인트의 오른쪽이 false이면 다음 포인트는 인자로 받은 값을 가진다.")
    void shouldReturnNextPointTrueOrFalse_whenPointRightFalse() {
        // given
        Point point = new Point(false);

        // when
        Point nextTrue = point.connectNext(true);
        Point nextFalse = point.connectNext(false);

        // then
        assertThat(nextTrue.right()).isTrue();
        assertThat(nextFalse.right()).isFalse();
    }
}
