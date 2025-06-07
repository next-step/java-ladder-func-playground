import generator.RandomGenerator;
import ladder.Row;
import ladder.Ladder;
import ladder.LadderGame;
import ladder.Column;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("LadderGame 생성 시 내부 Ladder에 최소 하나 이상 연결되어야 한다")
    void shouldGenerateLadderWithAtLeastOneLinked() {
        // given
        Row height = Row.from(4);
        Column width = Column.from(4);

        RandomLinkStrategy strategy = new RandomLinkStrategy(new RandomGenerator());
        LadderTuner tuner = new DefaultLadderTuner(strategy);

        LadderGame game = new LadderGame(height, width, strategy, tuner);

        // when
        Ladder ladder = game.getLadder();

        // then
        boolean atLeastOneLinked = ladder.getLines().stream()
                .flatMap(line -> line.getLinks().stream())
                .anyMatch(link -> link.isLinked());

        assertThat(atLeastOneLinked).isTrue();
    }

    @Test
    @DisplayName("LadderGame에서 getLadder 호출 시 Ladder 객체를 반환해야 한다")
    void shouldReturnLadderWhenGetLadderIsCalled() {
        // given
        Row height = Row.from(3);
        Column width = Column.from(4);

        RandomLinkStrategy strategy = new RandomLinkStrategy(new RandomGenerator());
        LadderTuner tuner = new DefaultLadderTuner(strategy);

        LadderGame game = new LadderGame(height, width, strategy, tuner);

        // when
        Ladder ladder = game.getLadder();

        // then
        assertThat(ladder).isNotNull();
    }
}