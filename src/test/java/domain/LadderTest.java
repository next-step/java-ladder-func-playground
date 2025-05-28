package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        List<Line> lines = new ArrayList<>();
        int width = 3;
        lines.add(Line.create(width, () -> false));

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertThatThrownBy(() -> {
            int modifiedWidth = 2;
            ladder.lines().add(Line.create(modifiedWidth, () -> true));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
