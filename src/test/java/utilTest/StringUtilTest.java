package utilTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.StringUtil;

import java.util.List;

public class StringUtilTest {
    @Test
    public void 문자들을_콤마기준으로_잘구분하는지_test(){
        //given
        String input="a,b,c,d";
        List<String>inputList=List.of("a","b","c","d");
        //when
        List<String>splitResult= StringUtil.splitByComma(input);
        //then
        Assertions.assertEquals(splitResult,inputList);
    }
}
