package util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import exception.CustomException;
import exception.ErrorMessage;

public class SizeValidatorTest {

    @Test
    void 음수를_검증_시_예외를_발생한다() {
        int negativeValue = -1;

        assertThatThrownBy(() -> SizeValidator.validateNotNegative(negativeValue))
            .isInstanceOf(CustomException.class)
            .hasMessage(ErrorMessage.NEGATIVE_NUMBER.getMessage());
    }

    @Test
    public void 음수가_아닌_정수를_검증_시_통과한다() {
        assertThatCode(() -> SizeValidator.validateNotNegative(0)).doesNotThrowAnyException();
        assertThatCode(() -> SizeValidator.validateNotNegative(10)).doesNotThrowAnyException();
    }
}
