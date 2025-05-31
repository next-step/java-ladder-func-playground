package domain;

import static domain.Ladder.MIN_LADDER_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리의 넓이가 생성 기준을 준수하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidLadderWidthSize() {
        // given
        int width = 1;
        int height = 3;

        assertThatThrownBy(() -> Ladder.create(width, height, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
    }

    @Test
    @DisplayName("사다리의 높이가 생성 기준을 준수하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidLadderHeightSize() {
        // given
        int width = 4;
        int height = 1;

        assertThatThrownBy(() -> Ladder.create(width, height, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
    }

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        int width = 4;
        int height = 4;

        // when
        Ladder ladder = Ladder.create(width, height, () -> false);

        // then
        assertThatThrownBy(() -> {
            int modifiedWidth = 2;
            ladder.getLines().add(Line.create(modifiedWidth, () -> true));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
