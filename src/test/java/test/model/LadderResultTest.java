package test.model;

import org.junit.jupiter.api.Test;

import model.LadderResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

class LadderResultTest {

    @Test
    void 특정_플레이어_결과_조회() {
        Map<String, String> results = Map.of("Neo", "꽝", "Tommy", "5000", "Brie", "꽝");
        LadderResult ladderResult = new LadderResult(results);

        assertEquals("5000", ladderResult.getResult("Tommy"));
        assertEquals("꽝", ladderResult.getResult("Neo"));
    }
}