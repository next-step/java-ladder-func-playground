package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {

    @Test
    @DisplayName("Line 생성 시 전달한 steps 목록을 보유")
    void testLineHoldsGivenSteps() {
        //given
        List<Step> steps = List.of(new Step(true), new Step(false), new Step(true));
        //when
        Line line = new Line(steps);
        //then
        Assertions.assertEquals(steps, line.steps());
    }

    @Test
    @DisplayName("Line의 steps 크기는 전달한 목록의 크기와 동일")
    void testLineStepsSize() {
        //given
        List<Step> steps = List.of(new Step(true), new Step(false), new Step(true), new Step(false));
        //when
        Line line = new Line(steps);
        //then
        Assertions.assertEquals(4, line.steps().size());
    }
}