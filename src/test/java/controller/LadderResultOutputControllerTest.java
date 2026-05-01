package controller;

import model.Ladder;
import model.LadderGame;
import model.Line;
import model.Players;
import model.Prizes;
import testComponents.TestLadderBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.util.List;

class LadderResultOutputControllerTest {

    LadderGame ladderGame;
    OutputView outputView;

    @BeforeEach
    void setupTest() {
        Line line = TestLadderBuilder.line(List.of(
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false),
                TestLadderBuilder.step(true)
        ));
        Ladder ladder = TestLadderBuilder.ladderOfSameLines(4, line);
        Players players = new Players(List.of("neo", "brown", "brie", "tomy"));
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        this.ladderGame = new LadderGame(players, prizes, ladder);
        this.outputView = new OutputView();
    }

    @Test
    @DisplayName("사다리 게임 결과를 예외 없이 출력한다")
    void printFullLadderExecutesWithoutException() {
        //given
        LadderResultOutputController controller = new LadderResultOutputController(ladderGame, outputView);

        //when
        //then
        Assertions.assertDoesNotThrow(controller::printFullLadder);
    }
}
