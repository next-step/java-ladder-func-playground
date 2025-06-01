package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedLineGenerator;
import strategy.LineGenerator;

class LadderFactoryTest {

    @Test
    @DisplayName("유효한 사다리를 생성하면 Ladder를 반환한다.")
    void draw_shouldReturnLadder_whenValid() {
        LineGenerator fixedGenerator = new FixedLineGenerator(List.of(
                new boolean[]{false, true, false, true},
                new boolean[]{true, false, true, false},
                new boolean[]{false, true, false, true},
                new boolean[]{true, false, true, false}
        ));
        LadderFactory factory = new LadderFactory();

        Ladder ladder = factory.draw(4, 4, fixedGenerator);

        assertThat(ladder).isNotNull();
        assertThat(ladder.isFullyConnected(4)).isTrue();
    }

    @Test
    @DisplayName("유효한 사다리를 최대 반복 횟수 내에 생성하지 못하면 예외를 던진다")
    void draw_shouldThrowException_whenInvalid() {
        LineGenerator fixedGenerator = new FixedLineGenerator(
                Collections.nCopies(200, new boolean[]{false, false, false, false})
        );
        LadderFactory factory = new LadderFactory();

        assertThatThrownBy(() -> factory.draw(4, 4, fixedGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 사다리를 생성할 수 없습니다.");
    }
}
