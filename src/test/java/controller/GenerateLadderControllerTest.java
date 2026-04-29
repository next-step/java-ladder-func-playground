package controller;

import model.LadderBuilder;
import model.LadderGame;
import model.Line;
import model.LineBuilder;
import testComponents.TestLadderBuilder;
import testComponents.TestLineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

class GenerateLadderControllerTest {

    @Test
    @DisplayName("사용자 입력을 받아 사다리 게임을 생성한다")
    void generateLadderGameCreatesLadderGameFromUserInput() {
        //given
        Line predefinedLine = TestLadderBuilder.line(List.of(
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false),
                TestLadderBuilder.step(true)
        ));


        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        LadderBuilder ladderBuilder = TestLadderBuilder.ladderBuilder(lineBuilder);
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream("neo,brown,brie,tommy\n꽝,5000,꽝,3000\n4".getBytes())));
        GenerateLadderGameController controller = new GenerateLadderGameController(ladderBuilder, inputView);

        //when & then
        LadderGame ladder = controller.generateLadderGame();

    }
}
