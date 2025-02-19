package test.model;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;


class LadderTest {

    @Test
    void 사다리_게임_결과_확인() {
        List<Player> players = List.of(new Player("Neo"), new Player("Tommy"), new Player("Brie"));
        List<String> results = List.of("1000", "꽝", "3000");

        Ladder ladder = new Ladder(players.size(), 5);
        LadderResult ladderResult = ladder.run(players, results);

        Map<String, String> resultMap = ladderResult.getAllResults();

        assertEquals(3, resultMap.size());
        assertTrue(resultMap.containsKey("Neo"));
        assertTrue(resultMap.containsKey("Tommy"));
        assertTrue(resultMap.containsKey("Brie"));
    }
}