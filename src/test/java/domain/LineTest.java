package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    private final static int MIN_WIDTH = 2;

    @Test
    void 사다리의_너비가_2미만_이면_예외가_발생한다() {
        assertThatThrownBy(() -> Line.create(1, () -> false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 너비는 " + MIN_WIDTH + " 이상이어야 합니다.");
    }

    @Test
    void 오른쪽에_가로줄이_있으면_인덱스가_1_증가한다() {
        // given-when
        Line line = Line.create(2, () -> true);
        // then
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void 왼쪽에_가로줄이_있으면_인덱스가_1_감소한다() {
        // given-when
        Line line = Line.create(2, () -> true);
        // then
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void 가로줄이_없으면_제자리에_머문다() {
        // given-when
        Line line = Line.create(2, () -> false);
        // then
        assertThat(line.move(0)).isEqualTo(0);
    }

    @Test
    void 가로줄은_연속해서_생성되지_않는다() {
        // given-when
        Line line = Line.create(4, () -> true);
        // then
        assertThat(line.getPoints()).containsExactly(true, false, true);
    }
}
