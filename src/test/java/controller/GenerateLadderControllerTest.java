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

import java.util.List;

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
        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        LadderBuilder ladderBuilder = TestLadderBuilder.ladderBuilder(lineBuilder);
        GenerateLadderController controller = new GenerateLadderController(ladderBuilder);

        //when
        Ladder ladder = controller.generateLadder();

        //then
        Assertions.assertEquals(4, ladder.lineList().size());
        for (Line line : ladder.lineList()) {
            Assertions.assertEquals(predefinedLine, line);
        }
    }
}