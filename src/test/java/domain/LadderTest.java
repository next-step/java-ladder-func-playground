package domain;

import static domain.Ladder.ERROR_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리 크기는 1 이상이어야한다")
    @Test
    void createInvalidLadder() {
        assertThatThrownBy(() -> Ladder.generate(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_SIZE);
    }

    @Test
    void move_ReturnsFinalPosition() {
        List<Line> lines = List.of(
                new Line(List.of(true, false, false)),
                new Line(List.of(true, false, false))
        );
        Ladder ladder = new Ladder(lines);
        assertThat(ladder.move(0)).isEqualTo(0);
    }
}