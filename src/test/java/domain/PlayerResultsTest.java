package domain;

import domain.prize.PrizeName;
import domain.user.PlayerName;
import domain.user.PlayerResults;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerResultsTest {

    @Test
    void 플레이어별_결과를_조회할_수_있다() {
        PlayerName name = new PlayerName("a");
        PrizeName prize = new PrizeName("100");

        PlayerResults results = new PlayerResults(Map.of(name, prize));
        assertEquals("100", results.get(name).getValue());
    }

    @Test
    void 존재하지_않는_플레이어는_예외() {
        PlayerResults results = new PlayerResults(Map.of(new PlayerName("a"), new PrizeName("100")));
        assertThrows(IllegalArgumentException.class, () -> results.get(new PlayerName("b")));
    }
}
