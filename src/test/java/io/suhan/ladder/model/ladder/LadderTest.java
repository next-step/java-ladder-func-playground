package io.suhan.ladder.model.ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LadderTest {
    @Test
    void 라인들을_저장할_수_있다() {
        List<Line> lines = List.of(
                new Line(List.of(new Connection(0, 1))),
                new Line(List.of(new Connection(1, 2)))
        );

        Ladder ladder = new Ladder(lines);

        assertEquals(lines.size(), ladder.lines().size());
        assertIterableEquals(lines, ladder.lines());
    }

    @Test
    void 라인_목록은_수정할_수_없다() {
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Connection(0, 1)))));

        assertThrows(UnsupportedOperationException.class, () -> ladder.lines().add(new Line(List.of(new Connection(1, 2)))));
    }
}
