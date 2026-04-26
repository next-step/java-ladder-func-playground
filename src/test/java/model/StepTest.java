package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepTest {

    @Test
    @DisplayName("isBlank이 true인 Step은 isBlank()가 true를 반환")
    void testIsBlankReturnsTrue() {
        //given
        Step step = new Step(true);
        //when
        boolean result = step.isBlank();
        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("isBlank이 false인 Step은 isBlank()가 false를 반환")
    void testIsBlankReturnsFalse() {
        //given
        Step step = new Step(false);
        //when
        boolean result = step.isBlank();
        //then
        Assertions.assertEquals(false, result);
    }
}
