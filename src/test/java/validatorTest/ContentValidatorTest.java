package validatorTest;

import org.junit.jupiter.api.Test;
import validator.ContentValidator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContentValidatorTest {
    @Test
    public void 이름이_5글자이하만_통과하는지_test() {
        //given
        List<String> nameListTrue = List.of("a", "bb");
        List<String> nameListFalse = List.of("a", "bbbbbv");
        //when
        boolean isTrue = ContentValidator.validateNameList(nameListTrue);
        boolean isFalse=ContentValidator.validateNameList(nameListFalse);
        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }

    @Test
    public void nameList에있는String_입력받는지_test(){
        //given
        List<String> nameList=List.of("a","b","c","d","e");
        String trueinput="a";
        String wronginput="bb";
        //when
        boolean isTrue=ContentValidator.validateGetTarget(trueinput,nameList);
        boolean isFalse=ContentValidator.validateGetTarget(wronginput,nameList);
        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }
}
