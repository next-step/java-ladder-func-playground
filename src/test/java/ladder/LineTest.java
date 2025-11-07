package ladder;

import model.ladder.Ladder;
import model.ladder.Line;
import model.ladder.generator.RandomConnectionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LineTest {
    @Test
    @DisplayName("Ladder 완성품에 연속된 발판이 없는지 검증한다")
    void ladderDoesNotHaveConsecutiveRungs() {
        int width = 5;
        int height = 10;

        Ladder ladder = new Ladder(width, height, new RandomConnectionGenerator());

        for (int row = 0; row < ladder.getHeight(); row++) {
            Line line = ladder.getLine(row);

            for (int i = 0; i < line.getPointCount() - 1; i++) {
                if (line.isConnectedAt(i)) {
                    assertFalse(line.isConnectedAt(i + 1));
                }
            }
        }
    }
}
