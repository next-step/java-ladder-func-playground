package ladderdomain;

import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import domain.user.GameInformation;
import domain.user.PlayerName;
import domain.user.PlayerNames;
import java.util.Map;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 특정_이름에_해당하는_결과를_찾을_수_있다() {
        PlayerNames playerNames = new PlayerNames(List.of(
                new PlayerName("a"), new PlayerName("b")));
        PrizeNames prizeNames = new PrizeNames(List.of(
                new PrizeName("100"), new PrizeName("200")));

        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of(true));
        Ladder ladder = new Ladder(1, 2, generator);

        GameInformation info = new GameInformation(playerNames, prizeNames);
        LadderGame game = new LadderGame(info, ladder);

        assertEquals("200", game.findResultByName(new PlayerName("a")).getValue());
        assertEquals("100", game.findResultByName(new PlayerName("b")).getValue());
    }

    @Test
    void 전체_결과_목록을_조회할_수_있다() {
        PlayerNames names = new PlayerNames(List.of(new PlayerName("a")));
        PrizeNames prizes = new PrizeNames(List.of(new PrizeName("꽝")));

        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of());
        Ladder ladder = new Ladder(0, 1, generator);

        GameInformation info = new GameInformation(names, prizes);
        LadderGame game = new LadderGame(info, ladder);

        Map<PlayerName, PrizeName> results = game.findAllResults();
        assertEquals(1, results.size());
        assertEquals("꽝", results.get(new PlayerName("a")).getValue());
    }
}
