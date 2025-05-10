package ladderdomain;

import domain.user.PlayerName;
import domain.user.PlayerNames;
import domain.user.PlayerResults;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import domain.ResultCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultCalculatorTest {

    @Test
    void 사다리를_통해_정상적으로_결과_계산된다() {
        PlayerNames playerNames = new PlayerNames(List.of(
                new PlayerName("a"), new PlayerName("b")));
        PrizeNames prizeNames = new PrizeNames(List.of(
                new PrizeName("1"), new PrizeName("2")));
        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of(false));
        Ladder ladder = new Ladder(0, 2, generator); // 그대로 매칭

        PlayerResults results = ResultCalculator.calculate(playerNames, ladder, prizeNames);
        assertEquals("1", results.get(playerNames.get(0)).getValue());
    }
}
