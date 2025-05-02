import Domain.*;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 특정_이름에_해당하는_결과를_찾을_수_있다() {
        PlayerNames playerNames = new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b")));
        PrizeNames prizeNames = new PrizeNames(List.of(new PrizeName("100"), new PrizeName("200")));
        GameInformation info = new GameInformation(playerNames, prizeNames);
        Ladder ladder = new Ladder(0, 2);

        LadderGame game = new LadderGame(info, ladder);
        assertEquals("100", game.findResultByName(new PlayerName("a")).getValue());
    }

    @Test
    void 전체_결과_목록을_조회할_수_있다() {
        PlayerNames names = new PlayerNames(List.of(new PlayerName("a")));
        PrizeNames prizes = new PrizeNames(List.of(new PrizeName("꽝")));
        GameInformation info = new GameInformation(names, prizes);
        LadderGame game = new LadderGame(info, new Ladder(0, 1));

        assertEquals(1, game.findAllResults().size());
    }
}
