package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepTest {

    @Test
    @DisplayName("비어있는 Step은 isBlank()가 true를 반환한다")
    void blankStepReturnsTrueOnIsBlank() {
        //given
        Step step = new Step(true);
        //when
        boolean result = step.isBlank();
        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("연결된 Step은 isBlank()가 false를 반환한다")
    void connectedStepReturnsFalseOnIsBlank() {
        //given
        Step step = new Step(false);
        //when
        boolean result = step.isBlank();
        //then
        Assertions.assertEquals(false, result);
    }
}
