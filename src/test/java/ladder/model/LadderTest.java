package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("다리가 최소 하나씩 생긴다")
    void minimumLadder() {
        int width = 5;
        int height = 10;
        LinkConnector linkConnector = new LinkConnector();
        Ladder ladder = new Ladder(width, height, linkConnector);
        List<List<Boolean>> lines = ladder.getLines();
        assertEquals(height, lines.size());
    }

    @Test
    @DisplayName("최소한의 넓이와 높이가 주어짐")
    void minimumSize() {
        LinkConnector linkConnector = new LinkConnector();
        Ladder ladder = new Ladder(2,2,linkConnector);
        List<List<Boolean>> lines = ladder.getLines();

        assertEquals(2, lines.size());
        for (int i = 0; i < lines.size(); i++) {
            List<Boolean> line = lines.get(i);
            assertEquals(1, line.size());
            assertTrue(line.get(0));
        }
    }
}
