package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Players;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedLineGenerator;
import strategy.LineGenerator;

class LadderFactoryTest {

    @Test
    @DisplayName("유효한 사다리를 생성하면 정상적인 사다리를 반환한다.")
    void shouldReturnLadder_whenValid() {
        // given
        LineGenerator fixedGenerator = new FixedLineGenerator(List.of(
                new boolean[]{false, true, false, true},
                new boolean[]{true, false, true, false},
                new boolean[]{false, true, false, true},
                new boolean[]{true, false, true, false}
        ));
        LadderFactory factory = new LadderFactory();
        List<String> names = List.of("dd", "dd2", "dd3");

        // when
        Ladder ladder = factory.draw(Players.from(names), Height.from(4), fixedGenerator);

        // then
        assertThat(ladder).isNotNull();
        assertThat(ladder.isFullyConnected(Players.from(names))).isTrue();
    }

    @Test
    @DisplayName("유효한 사다리를 최대 반복 횟수 내에 생성하지 못하면 예외가 발생한다.")
    void shouldThrowException_whenInvalidLadder() {
        // given
        int maxAttempts = 200;
        LineGenerator fixedGenerator = new FixedLineGenerator(
                Collections.nCopies(maxAttempts,
                        new boolean[]{false, false, false, false})
        );
        LadderFactory factory = new LadderFactory();
        List<String> names = List.of("dd", "dd2", "dd3");

        // when & then
        assertThatThrownBy(() -> factory.draw(Players.from(names), Height.from(4), fixedGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 사다리를 생성할 수 없습니다.");
    }
}
