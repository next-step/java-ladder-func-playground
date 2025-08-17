package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

    LadderGenerator ladderGenerator = new LadderGenerator(new Random());

    @Test
    void 높이와_너비에_맞는_사다리를_생성한다() {
        Height height = new Height(3);
        Width width = new Width(4);
        Ladder ladder = ladderGenerator.generate(height, width);

        assertThat(ladder.getLines()).hasSize(height.getHeight());

        for (Line line : ladder.getLines()) {
            assertThat(line.getConnections()).hasSize(width.getWidth() - 1);
        }
    }

    @Test
    void 연속된_라인이_존재하지_않도록_사다리가_생성된다() {
        Height height = new Height(10);
        Width width = new Width(10);

        Ladder ladder = ladderGenerator.generate(height, width);

        for (Line line : ladder.getLines()) {
            List<Boolean> connections = line.getConnections();

            for (int i = 1; i < connections.size(); i++) {
                if (connections.get(i - 1)) {
                    assertThat(connections.get(i)).isFalse();
                }
            }
        }
    }
}
