package model;

import constants.ErrorMessage;
import constants.LadderConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LineTest {

    @Test
    @DisplayName("Line 생성 시 전달한 steps 목록을 보유")
    void testLineHoldsGivenGetSteps() {
        //given
        List<Step> steps = List.of(new Step(true), new Step(false), new Step(true));
        //when
        Line line = new Line(steps);
        //then
        Assertions.assertEquals(steps, line.getSteps());
    }

    @Test
    @DisplayName("Line의 steps 크기는 전달한 목록의 크기와 동일")
    void testLineGetStepsSize() {
        //given
        List<Step> steps = List.of(new Step(true), new Step(false), new Step(true), new Step(false));
        //when
        Line line = new Line(steps);
        //then
        Assertions.assertEquals(4, line.getSteps().size());
    }

    @Test
    @DisplayName("연속된 두 Step이 모두 연결되어 있으면 IllegalArgumentException 발생")
    void testLineWithConsecutiveConnectionsThrows() {
        //given
        List<Step> invalidSteps = List.of(new Step(false), new Step(false));
        //when & then
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Line(invalidSteps)
        );

        Assertions.assertEquals(ErrorMessage.CONSECUTIVE_STEPS_IN_A_ROW, exception.getMessage());
    }

    @Test
    @DisplayName("중간에 연속된 두 Step이 모두 연결되어 있으면 IllegalArgumentException 발생")
    void testLineWithConsecutiveConnectionsInMiddleThrows() {
        //given
        List<Step> invalidSteps = List.of(new Step(true), new Step(false), new Step(false), new Step(true));
        //when & then
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Line(invalidSteps)
        );

        Assertions.assertEquals(ErrorMessage.CONSECUTIVE_STEPS_IN_A_ROW, exception.getMessage());
    }

    @Test
    @DisplayName("Line의 width가 최소값 미만이면 IllegalArgumentException 발생")
    void testLineWithInsufficientWidthThrows() {
        //given
        List<Step> tooNarrowSteps = new ArrayList<>();
        for(int i = 0; i < LadderConstants.MINIMUM_LINE_WIDTH - 1; i++) {
            tooNarrowSteps.add(new Step(true));
        }
        //when & then
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Line(tooNarrowSteps)
        );

        Assertions.assertEquals(ErrorMessage.LINE_NOT_LONG_ENOUGH, exception.getMessage());
    }

    @Test
    @DisplayName("moveAlongTheRow: 왼쪽 step이 연결되어 있으면 index가 1 감소")
    void testMoveAlongTheRowMovesLeft() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        //when
        Integer result = line.moveAlongTheRow(1);
        //then
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("moveAlongTheRow: 오른쪽 step이 연결되어 있으면 index가 1 증가")
    void testMoveAlongTheRowMovesRight() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        //when
        Integer result = line.moveAlongTheRow(0);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("moveAlongTheRow: 양쪽 step이 모두 비어있으면 index 유지")
    void testMoveAlongTheRowStaysWhenBothBlank() {
        //given
        Line line = new Line(List.of(new Step(true), new Step(false), new Step(true)));
        //when
        Integer result = line.moveAlongTheRow(0);
        //then
        Assertions.assertEquals(0, result);
    }
}