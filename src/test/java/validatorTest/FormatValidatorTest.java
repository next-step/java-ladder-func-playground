package validatorTest;

import org.junit.jupiter.api.Test;
import validator.FormatValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormatValidatorTest {
    @Test
    public void 이름을_콤마기준으로_입력받는지_Test(){
        //given
        String trueInput="a,b,c,d,e";
        String falseInput="a.b,c,d";
        //when
        boolean isTrue= FormatValidator.validateCommaSeparatedFormat(trueInput);
        boolean isFalse=FormatValidator.validateCommaSeparatedFormat(falseInput);
        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }

    @Test
    public void 숫자만을_통과시키는지_Test(){
        //given
        String trueInput="1";
        String falseInput="a";
        //when
        boolean isTrue= FormatValidator.validateIntegerFormat(trueInput);
        boolean isFalse=FormatValidator.validateIntegerFormat(falseInput);
        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }

}
