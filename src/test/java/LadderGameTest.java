import ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomLinkStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("LadderGame 생성 시 내부 Ladder에 최소 하나 이상 연결되어야 한다")
    void shouldGenerateLadderWithAtLeastOneLinked() {
        // given
        int row = 4;
        int column = 4;
        LadderGame game = new LadderGame(row, column, new RandomLinkStrategy());

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
        LadderGame game = new LadderGame(3, 4, new RandomLinkStrategy());

        // when
        Ladder ladder = game.getLadder();

        // then
        assertThat(ladder).isNotNull();
    }
}