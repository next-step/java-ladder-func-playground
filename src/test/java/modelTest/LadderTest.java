package modelTest;

import domain.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    public void 사다리생성시_width_heigth_제대로_저장되는지_test(){
        //given
        int width=3;
        int height=4;
        //when
        Ladder ladder=new Ladder(height,width);
        //then
        Assertions.assertEquals(width,ladder.getWidth());
        Assertions.assertEquals(height,ladder.getHeight());
    }

    @Test
    public void 사다리생성시_Line이_height만큼_생성되는지_test(){
        //given
        int width=3;
        int height=4;
        //when
        Ladder ladder=new Ladder(height,width);
        //then
        Assertions.assertEquals(height,ladder.getLadder().size());
    }

}
