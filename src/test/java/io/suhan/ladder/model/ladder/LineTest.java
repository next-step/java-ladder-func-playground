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
public class LineTest {
    @Test
    void 연결들을_저장할_수_있다() {
        List<Connection> connections = List.of(new Connection(0, 1));
        Line line = new Line(connections);

        assertEquals(connections.size(), line.getConnections().size());
        assertIterableEquals(connections, line.getConnections());
    }

    @Test
    void 연결_목록은_수정할_수_없다() {
        Line line = new Line(List.of(new Connection(0, 1)));

        assertThrows(UnsupportedOperationException.class, () -> line.getConnections().add(new Connection(1, 2)));
    }
}
