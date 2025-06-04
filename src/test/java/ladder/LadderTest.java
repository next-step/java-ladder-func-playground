package ladder;

import generator.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 시, row 수만큼 Line이 생성되어야 한다")
    void shouldCreateLinesEqualToRowCount() {
        // given
        Height height = Height.from(3);
        Width  width = Width.from(4);

        RandomLinkStrategy strategy = new RandomLinkStrategy(new RandomGenerator());
        LadderTuner tuner = new DefaultLadderTuner(strategy);

        // when
        Ladder ladder = new Ladder(height, width, strategy, tuner);

        // then
        List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(height.height());
    }

    @Test
    @DisplayName("generateLadder 호출 시, 최소 하나 이상의 Link가 연결되어야 한다")
    void shouldGenerateAtLeastOneLinkWhenLadderIsInitialized() {
        // given
        Height height = Height.from(3);
        Width  width = Width.from(4);

        RandomLinkStrategy strategy = new RandomLinkStrategy(new RandomGenerator());
        LadderTuner tuner = new DefaultLadderTuner(strategy);

        Ladder ladder = new Ladder(height, width, strategy, tuner);

        // when
        boolean atLeastOneLinked = ladder.getLines().stream()
                .flatMap(line -> line.getLinks().stream())
                .anyMatch(link -> link.isLinked());

        // then
        assertThat(atLeastOneLinked).isTrue();
    }
}