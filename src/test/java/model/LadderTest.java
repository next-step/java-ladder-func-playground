package model;

import dto.LadderResultDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderTest {
    @Test
    @DisplayName("사다리의 높이 테스트")
    void testCalculateHeight() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        Ladder ladder = new Ladder(List.of(line, line, line));
        //when
        Integer height = ladder.calculateHeight();
        //then
        Assertions.assertEquals(3, height);
    }

    @Test
    @DisplayName("calculateWidth는 첫 Line의 step 개수 + 1을 반환")
    void testCalculateWidth() {
        //given
        Line line = new Line(List.of(new Step(false), new Step(true), new Step(false)));
        Ladder ladder = new Ladder(List.of(line));
        //when
        Integer width = ladder.calculateWidth();
        //then
        Assertions.assertEquals(4, width);
    }

    @Test
    @DisplayName("calculateSingleResultAsDto: 각 Line의 moveAlongTheRow가 직전 결과를 인자로 순서대로 호출됨")
    void testCalculateSingleResultAsDtoMovesLeft() {
        //given
        List<Step> steps = List.of(new Step(false), new Step(true), new Step(false));
        MoveTrackingLine firstLine = new MoveTrackingLine(steps, 2);
        MoveTrackingLine secondLine = new MoveTrackingLine(steps, 3);
        MoveTrackingLine thirdLine = new MoveTrackingLine(steps, 1);
        Ladder ladder = new Ladder(List.of(firstLine, secondLine, thirdLine));
        //when
        LadderResultDto result = ladder.calculateSingleResultAsDto(0);
        //then
        Assertions.assertEquals(1, firstLine.callCount);
        Assertions.assertEquals(0, firstLine.receivedIndex);

        Assertions.assertEquals(1, secondLine.callCount);
        Assertions.assertEquals(2, secondLine.receivedIndex);

        Assertions.assertEquals(1, thirdLine.callCount);
        Assertions.assertEquals(3, thirdLine.receivedIndex);

        Assertions.assertEquals(0, result.startIndex());
        Assertions.assertEquals(1, result.endIndex());
    }

    private static class MoveTrackingLine extends Line {
        private final Integer stubbedReturn;
        int callCount = 0;
        Integer receivedIndex;

        MoveTrackingLine(List<Step> steps, Integer stubbedReturn) {
            super(steps);
            this.stubbedReturn = stubbedReturn;
        }

        @Override
        public Integer moveAlongTheRow(Integer index) {
            this.callCount++;
            this.receivedIndex = index;
            return stubbedReturn;
        }
    }
}