package io.suhan.ladder.model.ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LadderFactoryTest {
    @Test
    void 사다리는_올바른_높이를_가진다() {
        Ladder ladder = LadderFactory.createLadder(5, 4);

        assertEquals(4, ladder.lines().size());
    }

    @Test
    void 사다리의_가로_라인이_겹치지_않는다() {
        // given
        Random fixedRandom = new Random(3L);
        int width = 4;
        int height = 5;

        // when
        Ladder ladder = LadderFactory.createLadder(width, height, fixedRandom);

        // then
        for (int row = 0; row < ladder.lines().size(); row++) {
            Line line = ladder.lines().get(row);
            List<Connection> connections = line.connections();

            for (int i = 0; i < connections.size() - 1; i++) {
                Connection current = connections.get(i);
                Connection next = connections.get(i + 1);

                int diff = next.left() - current.left();

                // diff = 1 if overlaps
                assertTrue(diff > 1);
            }
        }
    }
}
