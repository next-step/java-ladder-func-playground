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
import view.InputView;
import view.OutputView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

class LadderGameControllerTest {

    LadderGame ladderGame;
    OutputView outputView;

    @BeforeEach
    void setupTest() {
        Line line = TestLadderBuilder.line(List.of(TestLadderBuilder.step(true), TestLadderBuilder.step(false), TestLadderBuilder.step(true)));
        Ladder ladder = TestLadderBuilder.ladderOfSameLines(4, line);
        Players players = new Players(List.of("neo", "brown", "brie", "tomy"));
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        this.ladderGame = new LadderGame(players, prizes, ladder);
        this.outputView = new OutputView();
    }

    @Test
    @DisplayName("'all' 입력 시 모든 결과를 예외 없이 출력한다")
    void playGameWithAllExecutesWithoutException() {
        //given
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream("all\n".getBytes())));
        LadderGameController controller = new LadderGameController(inputView, outputView, ladderGame);

        //when & then
        Assertions.assertDoesNotThrow(controller::playGame);
    }

    @Test
    @DisplayName("개별 플레이어 이름을 입력 후 'all'을 입력하면 예외 없이 종료된다")
    void playGameWithSingleEntryThenAllExecutesWithoutException() {
        //given
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream("neo\nall\n".getBytes())));
        LadderGameController controller = new LadderGameController(inputView, outputView, ladderGame);

        //when & then
        Assertions.assertDoesNotThrow(controller::playGame);
    }
}
