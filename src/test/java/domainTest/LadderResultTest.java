package domainTest;

import domain.Ladder;
import domain.LadderResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderResultTest {
    @Test
    public void 이름과_타켓값을_제대로저장하는지_test(){
        //given
        List<String> names = List.of("a", "b", "c", "d");
        List<String> targets=List.of("1","2","3","4");
        //when
        LadderResult ladderResult=new LadderResult(new Ladder(2,3),names,targets);
        //then
        Assertions.assertEquals(names,ladderResult.getNames());
        Assertions.assertEquals(targets,ladderResult.getTargets());
    }

    @Test
    public void IntgerResult에대해서_0_플레이어수만큼_가지는지_test(){
        //given
        List<String> names = List.of("a", "b", "c", "d");
        List<String> targets=List.of("1","2","3","4");
        int width=3;
        //when
        LadderResult ladderResult=new LadderResult(new Ladder(2,width),names,targets);
        int objectSize=width+1;
        //then
        for(int i=0;i<objectSize;i++){
            Assertions.assertTrue(ladderResult.getLadderIntegerResult().containsKey(i));
        }
    }

    @Test
    public void StringResult에_대해서_1대1대응하는_이름_target_가지는지_test(){
        //given
        List<String> names = List.of("a", "b", "c", "d");
        List<String> targets=List.of("1","2","3","4");
        int width=3;
        //when
        LadderResult ladderResult=new LadderResult(new Ladder(2,width),names,targets);
        int objectSize=width+1;
        //then
        for(String name:names){
            Assertions.assertTrue(ladderResult.getLadderStringResult().containsKey(name));
        }
        for(String target:targets){
            Assertions.assertTrue(ladderResult.getLadderStringResult().containsValue(target));
        }
    }

}
