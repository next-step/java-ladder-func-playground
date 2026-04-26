package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderBuilderTest {

    LadderBuilder ladderBuilder;

    @Test
    @DisplayName("주어진 height만큼의 Line을 가진 Ladder 생성")
    void testGenerateLadderHeight() {
        //given
        Line predefinedLine = new Line(List.of(new Step(true), new Step(false), new Step(true), new Step(false)));
        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        ladderBuilder = new LadderBuilder(lineBuilder);
        int height = 4;
        int width = 4;
        //when
        Ladder ladder = ladderBuilder.generateLadder(height, width);
        //then
        Assertions.assertEquals(height, ladder.lineList().size());
    }

    @Test
    @DisplayName("height가 0이면 빈 lineList를 가진 Ladder 반환")
    void testGenerateLadderWithZeroHeight() {
        //given
        Line predefinedLine = new Line(List.of(new Step(true)));
        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        ladderBuilder = new LadderBuilder(lineBuilder);
        //when
        Ladder ladder = ladderBuilder.generateLadder(0, 1);
        //then
        Assertions.assertEquals(0, ladder.lineList().size());
    }
}