package controller;

import model.Ladder;
import model.LadderBuilder;
import model.Line;
import model.LineBuilder;
import testComponents.TestLadderBuilder;
import testComponents.TestLineBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

class GenerateLadderControllerTest {

    @Test
    @DisplayName("계층 통합 테스트: 사다리 생성 컨트롤러 테스트")
    void generateLadder_calls_intended_functions() {
        //given
        Line predefinedLine = TestLadderBuilder.line(List.of(
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false),
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false)
        ));
        final int TEST_HEIGHT = 10;
        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        LadderBuilder ladderBuilder = TestLadderBuilder.ladderBuilder(lineBuilder);
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream("%d\n4".formatted(TEST_HEIGHT).getBytes())));
        GenerateLadderGameController controller = new GenerateLadderGameController(ladderBuilder, inputView);

        //when
        Ladder ladder = controller.generateLadderGame();

        //then
        Assertions.assertEquals(TEST_HEIGHT, ladder.calculateHeight());
    }
}