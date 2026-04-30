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

    @Test
    public void 두줄이겹쳐져서_그려지지않는지_test(){
        //given
        int width=5;
        List<Boolean> line =LineGenerator.makeLine(width);
        Assertions.assertDoesNotThrow(()->validateNoConsecutiveTrue(line));
    }

    private void validateNoConsecutiveTrue(List<Boolean> line){
        for(int i=0;i<line.size()-1;i++){
            if(line.get(i)&&line.get(i+1)){
                throw new IllegalArgumentException("연속된 true 존재Error");
            }
        }
    }

}
