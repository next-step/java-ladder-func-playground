package model;

import constants.LadderConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testComponents.TestLineBuilder;

import java.util.ArrayList;
import java.util.List;

class LadderBuilderTest {

    LadderBuilder ladderBuilder;

    @Test
    @DisplayName("주어진 height만큼의 Line을 가진 Ladder를 생성한다")
    void generateLadderCreatesLadderWithGivenHeight() {
        //given
        Line predefinedLine = new Line(List.of(new Step(true), new Step(false), new Step(true), new Step(false)));

        LineBuilder lineBuilder = new TestLineBuilder(predefinedLine);
        ladderBuilder = new LadderBuilder(lineBuilder);
        int height = 4;
        int width = 4;

        //when
        Ladder ladder = ladderBuilder.generateLadder(height, width);

        //then
        Assertions.assertEquals(height, ladder.calculateHeight());
    }

    @Test
    @DisplayName("height가 0이면 빈 lineList를 가진 Ladder를 반환한다")
    void generateLadderReturnsEmptyLadderWhenHeightIsZero() {
        //given
        List<Step> predefinedLine = new ArrayList<>();
        for (int i = 0; i < LadderConstants.MINIMUM_LINE_WIDTH; i++) {
            predefinedLine.add(new Step(true));
        }
        LineBuilder lineBuilder = new TestLineBuilder(new Line(predefinedLine));
        ladderBuilder = new LadderBuilder(lineBuilder);

        //when
        Ladder ladder = ladderBuilder.generateLadder(0, LadderConstants.MINIMUM_LINE_WIDTH);

        //then
        Assertions.assertEquals(0, ladder.calculateHeight());
    }
}
