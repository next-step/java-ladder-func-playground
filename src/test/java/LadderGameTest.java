import ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("initialize 호출 시 Ladder의 generateLadder가 정상적으로 실행되어야 한다")
    void ShouldGenerateLadderWhenInitializeIsCalled() {
        // given
        int row = 4;
        int column = 4;
        LadderGame game = new LadderGame(row, column);

        // when
        game.initialize();

        // then
        Ladder ladder = game.getLadder();
        boolean atLeastOneLinked = ladder.getLines().stream()
                .flatMap(line -> line.getLinks().stream())
                .anyMatch(link -> link.isLinked());

        assertThat(atLeastOneLinked).isTrue();
    }

    @Test
    @DisplayName("LadderGame에서 getLadder 호출 시 Ladder 객체를 반환해야 한다")
    void ShouldReturnLadderWhenGetLadderIsCalled() {
        // given
        LadderGame game = new LadderGame(3, 4);

        // when
        Ladder ladder = game.getLadder();

        // then
        assertThat(ladder).isNotNull();
    }
}