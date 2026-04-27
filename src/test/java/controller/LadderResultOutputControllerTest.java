package controller;

import model.Ladder;
import model.Line;
import testComponents.TestLadderBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.util.List;

class LadderResultOutputControllerTest {

    Ladder ladder;
    OutputView outputView;
    ByteArrayOutputStream capturedOut;

    @BeforeEach
    void setupTest() {
        Line line = TestLadderBuilder.line(List.of(
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false),
                TestLadderBuilder.step(true),
                TestLadderBuilder.step(false)
        ));
        this.ladder = TestLadderBuilder.ladderOfSameLines(4, line);
        this.outputView = new OutputView();
        this.capturedOut = new ByteArrayOutputStream();
    }

    @Test
    @DisplayName("계층 통합 테스트: 사다리 출력 컨트롤러")
    void printLadder_calls_intended_functions() {
        //given
        LadderResultOutputController controller = new LadderResultOutputController(ladder, outputView);

        //when
        //then
        Assertions.assertDoesNotThrow(controller::printLadderResults);
    }
}