package io.suhan.ladder.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class ParticipantTest {
    @Test
    void 참가자_이름은_5자_이하만_가능하다() {
        assertThrows(IllegalArgumentException.class, () -> new Participant("123456"));
    }
}
