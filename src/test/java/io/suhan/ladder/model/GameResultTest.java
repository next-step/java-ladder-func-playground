package io.suhan.ladder.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class GameResultTest {
    @Test
    void 게임_결과는_수정할_수_없다() {
        Map<Participant, String> entry = Map.of(new Participant("p1"), "o1");
        GameResult result = new GameResult(entry);

        assertThrows(UnsupportedOperationException.class, () -> result.results().put(new Participant("p2"), "o2"));
    }
}
