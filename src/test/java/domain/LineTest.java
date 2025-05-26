package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("가로 라인은 겹치지 않아야한다.")
    @Test
    void createInvalidLine() {
        List<Boolean> points = List.of(true, true, false);
        Assertions.assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인은 겹치지 않아야합니다.");
    }
}