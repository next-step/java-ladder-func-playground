package domain;

import static domain.Line.ERROR_DUPLICATE_LINES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("가로 라인은 겹치지 않아야한다")
    @Test
    void createInvalidLine() {
        List<Boolean> points = List.of(true, true, false);
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_LINES);
    }

    @Test
    void moveRight() {
        Line line = new Line(List.of(true, false, false));
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void moveLeft() {
        Line line = new Line(List.of(true, false, false));
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void dontMove() {
        Line line = new Line(List.of(false, false, false));
        assertThat(line.move(0)).isEqualTo(0);
    }
}