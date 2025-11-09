package io.suhan.ladder.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class OutcomeTest {
    @Test
    void 결과_값은_공백일_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new Outcome(""));
    }
}
