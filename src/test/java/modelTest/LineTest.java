package modelTest;

import domain.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.LineGenerator;

import java.util.Arrays;
import java.util.List;

public class LineTest {
    @Test
    public void line이_width를_제대로저장하는지_test() {
        //given
        int width = 3;
        //when
        Line line = new Line(width, LineGenerator.makeLine(width));
        //then
        Assertions.assertEquals(line.getWidth(), width);
    }

    @Test
    public void line이_width만큼_boolean을_갖고있는지_test() {
        //given
        int width = 3;
        //when
        Line line = new Line(width, LineGenerator.makeLine(width));
        //then
        Assertions.assertEquals(width, line.getLine().size());
    }

    @Test
    public void player가_왼쪽으로이동하는지_test() {
        //given
        int width = 2;
        List<Boolean> lineValue = Arrays.asList(true, false);

        int player = 1;
        int playerMoveAfter = 0;

        //when
        Line line = new Line(width, lineValue);

        Assertions.assertEquals(playerMoveAfter, line.move(player));
    }

    @Test
    public void player가_오른쪽으로이동하는지_test() {
        //given
        int width = 2;
        List<Boolean> lineValue = Arrays.asList(false, true);

        int player = 1;
        int playerMoveAfter = 2;

        //when
        Line line = new Line(width, lineValue);

        Assertions.assertEquals(playerMoveAfter, line.move(player));
    }

    @Test
    public void player가_불필요할때_안움직이는지_test() {
        //given
        int width = 2;
        List<Boolean> lineValue = Arrays.asList(false, false);

        int player = 1;
        int playerMoveAfter = 1;

        //when
        Line line = new Line(width, lineValue);

        Assertions.assertEquals(playerMoveAfter, line.move(player));
    }
}
