package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void getLines() {
    }

    @Test
    @DisplayName("가로에 연속으로 다리가 생기지 않음")
    void notContinuousLadder() {
        LinkConnector linkConnector = new LinkConnector();
        int width = 10;
        for (int i = 0; i < 10; i++) {
            List<Boolean> links = linkConnector.generate(width);
            for (int j = 0; j < links.size() - 1; j++) {
                assertFalse(links.get(j) && links.get(j + 1));
                // false 가 나오면 테스트 통과
            }
        }
    }

    @Test
    @DisplayName("다리가 최소 하나씩 생긴다")
    void minimumLadder() {
        int width = 5;
        int height = 10;
        LinkConnector linkConnector = new LinkConnector();
        Ladder ladder = new Ladder(width, height, linkConnector);
        List<Line> lines = ladder.getLines();

        assertEquals(height, lines.size());
    }
}