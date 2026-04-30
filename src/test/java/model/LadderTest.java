package model;

import dto.LadderResultDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderTest {
    @Test
    @DisplayName("calculateHeight는 Ladder가 보유한 Line의 개수를 반환한다")
    void calculateHeightReturnsNumberOfLines() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        Ladder ladder = new Ladder(List.of(line, line, line));
        //when
        Integer height = ladder.calculateHeight();
        //then
        Assertions.assertEquals(3, height);
    }

    @Test
    @DisplayName("calculateWidth는 첫 Line의 step 개수 + 1을 반환한다")
    void calculateWidthReturnsFirstLineStepCountPlusOne() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        Ladder ladder = new Ladder(List.of(line));
        //when
        Integer width = ladder.calculateWidth();
        //then
        Assertions.assertEquals(4, width);
    }

    @Test
    @DisplayName("calculateSingleResultAsDto는 각 Line의 moveAlongTheRow를 직전 결과를 인자로 순서대로 호출한다")
    void calculateSingleResultAsDtoCallsEachLineMoveAlongTheRowInOrder() {
        //given
        List<Step> stepsFirst = List.of(new Step(false),new Step(true), new Step(true));
        List<Step> stepsSecond = List.of(new Step(true), new Step(false), new Step(true));
        List<Step> stepsThird = List.of(new Step(true), new Step(true), new Step(false));
        Line firstLine = new Line(stepsFirst);
        Line secondLine = new Line(stepsSecond);
        Line thirdLine = new Line(stepsThird);
        Ladder ladder = new Ladder(List.of(firstLine, secondLine, thirdLine));
        //when
        LadderResultDto result = ladder.calculateSingleResultAsDto(0);
        //then
        Assertions.assertEquals(3, result.endIndex());
    }
}
