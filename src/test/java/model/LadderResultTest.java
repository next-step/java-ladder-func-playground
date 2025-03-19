package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class LadderResultTest {

    private List<String> player;
    private List<String> prize;

    @BeforeEach
    void setUp() {
        player = List.of("Gold", "nana", "Broze");
        prize = List.of("꽝", "3000", "5000");
    }

    private LadderResult createLadderResult(List<String> player, List<String> prize) {
        Players players = new Players(player);
        Prizes prizes = Prizes.createPrizes(prize, players);

        List<Line> lines = List.of(
                new Line(List.of(Point.HAS_POINT, Point.NO_POINT)),
                new Line(List.of(Point.NO_POINT, Point.HAS_POINT))
        );
        Ladder ladder = new Ladder(lines);
        LadderResult ladderResult = new LadderResult(ladder);
        ladderResult.calculateResults(player, prizes);
        return ladderResult;
    }

    @Test
    @DisplayName("플레이어 이름에 대한 결과를 올바르게 계산한다.")
    void shouldCalculateResultsCorrectly() {
        LadderResult ladderResult = createLadderResult(player, prize);

        assertThat(ladderResult.getValue().values()).containsExactly("5000", "꽝", "3000");
    }

    @Test
    @DisplayName("결과가 없는 플레이어에 대해 '결과 없음'을 반환한다.")
    void shouldReturnNoResultWhenPlayerNotFound() {
        LadderResult ladderResult = createLadderResult(player, prize);

        assertThat(ladderResult.getResultForPlayer("NonExistPlayer")).isEqualTo("결과 없음");
    }
}
