import model.Ladder;
import model.LadderFactory;
import model.LadderSize;
import model.Line;
import model.Point;
import model.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 테스트")
public class LadderTest {

    @Test
    @DisplayName("높이가 0 이하면 예외가 발생한다")
    void ladderSizeThrowsExceptionForInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> new LadderSize(4, 0));
        assertThrows(IllegalArgumentException.class, () -> new LadderSize(4, -1));
    }

    @Test
    @DisplayName("가로줄은 서로 연결될 수 없다")
    void factoryPreventsConsecutiveConnections() {
        LadderFactory factory = new LadderFactory();
        LadderSize size = new LadderSize(5, 10);

        Ladder ladder = factory.create(size, 5);

        for (Line line : ladder.lines()) {
            List<Point> points = line.points();
            for (int i = 0; i < points.size() - 1; i++) {
                if (points.get(i).isConnected()) {
                    assertFalse(points.get(i + 1).isConnected());
                }
            }
        }
    }

    @Test
    @DisplayName("LadderGame - 연결선이 없으면 그대로 내려간다")
    void gameMovesDownWithoutConnection() {
        List<Point> line = Arrays.asList(new Point(false), new Point(false), new Point(false));
        Ladder ladder = new Ladder(Arrays.asList(new Line(line)));

        List<String> participants = Arrays.asList("neo", "brown", "brie", "tommy");
        List<String> results = Arrays.asList("꽝", "5000", "꽝2", "3000");

        LadderGame game = new LadderGame(ladder, 4);

        assertEquals("꽝", game.getResult("neo", participants, results));
        assertEquals("5000", game.getResult("brown", participants, results));
    }

}
