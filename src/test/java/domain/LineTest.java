package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("한 줄에서 이동 로직이 정상 작동하는지 확인")
    void line_move() {
        LadderRow line = new LadderRow(3, count -> Arrays.asList(
                new LadderStep(0, false, true),
                new LadderStep(1, true, false),
                new LadderStep(2, false, false)
        ));

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
