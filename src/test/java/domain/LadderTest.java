package domain;

import static domain.dto.RequestLadder.MIN_LADDER_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedLineGenerator;
import strategy.LineGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리의 넓이가 생성 기준을 준수하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidLadderWidthSize() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{true}));
        int width = 1;
        int height = 3;

        assertThatThrownBy(() -> Ladder.create(width, height, generator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
    }

    @Test
    @DisplayName("사다리의 높이가 생성 기준을 준수하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidLadderHeightSize() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(new boolean[]{true, false, true, false}));
        int width = 4;
        int height = 1;

        assertThatThrownBy(() -> Ladder.create(width, height, generator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
    }

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(
                new boolean[]{true, false, true, false},
                new boolean[]{false, false, true, true},
                new boolean[]{true, false, true, false},
                new boolean[]{false, false, true, true}
        ));
        int width = 4;
        int height = 4;

        // when
        Ladder ladder = Ladder.create(width, height, generator);

        // then
        Line newLine = ladder.getLines().get(0);
        assertThatThrownBy(() -> ladder.getLines().add(Line.of(newLine.points)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
