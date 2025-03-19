package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class LadderGameTest {

    private Players players;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        List<String> playerNames = List.of("Gold", "nana", "Broze");
        List<String> prizeList = List.of("꽝", "3000", "5000");
        players = new Players(playerNames);
        prizes = Prizes.createPrizes(prizeList, players);
    }

    @Test
    @DisplayName("게임 생성 시 정상적으로 생성된다.")
    void shouldCreateLadderGameCorrectly() {
        PointGenerator pointGenerator = new PointGenerator(new FixedNumberGenerator(1));
        Height maxHeight = new Height(5);

        LadderGame ladderGame = LadderGame.createGame(players, maxHeight, pointGenerator, prizes);

        assertThat(ladderGame).isExactlyInstanceOf(LadderGame.class);
    }

    @Test
    @DisplayName("게임의 레더 포인트가 비어 있지 않는다.")
    void shouldHaveNonEmptyLadderPoints() {
        PointGenerator pointGenerator = new PointGenerator(new FixedNumberGenerator(1));
        Height maxHeight = new Height(5);
        LadderGame ladderGame = LadderGame.createGame(players, maxHeight, pointGenerator, prizes);

        assertThat(ladderGame.getLadderPoints()).isNotEmpty();
    }

    @Test
    @DisplayName("게임에서 모든 플레이어의 결과가 예상된 보상과 일치한다.")
    void shouldHaveCorrectResultsForAllPlayers() {
        PointGenerator pointGenerator = new PointGenerator(new FixedNumberGenerator(1));
        Height maxHeight = new Height(5);
        LadderGame ladderGame = LadderGame.createGame(players, maxHeight, pointGenerator, prizes);

        assertThat(ladderGame.getAllResultForPlayers().values())
                .containsExactly("3000", "꽝", "5000");
    }
}
