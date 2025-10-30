package io.suhan.ladder.model.ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class ConnectionTest {
    @Test
    void Left와_Right_정보를_반환할_수_있다() {
        Connection connection = new Connection(0, 1);

        assertEquals(0, connection.getLeft());
        assertEquals(1, connection.getRight());
    }
}
