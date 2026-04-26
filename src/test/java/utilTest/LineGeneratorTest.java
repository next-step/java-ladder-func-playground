package utilTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.LineGenerator;

import java.util.List;

public class LineGeneratorTest {
    @Test
    public void width개수와동일한_points들을생성하는지_test(){
        //given
        int width=3;
        List<Boolean> line=LineGenerator.makeLine(width);
        //when

        //then
        Assertions.assertEquals(width,line.size());
    }
}
