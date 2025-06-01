package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Line;
import domain.Point;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        List<Line> lines = List.of(Line.from(List.of(Point.from(true))));
        Ladder ladder = Ladder.from(lines);

        // when & then
        assertThatThrownBy(() -> ladder.getLines().add(Line.from(List.of(Point.from(false)))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
