package domain;

import generator.TestConnectionGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private static final int LADDER_WIDTH = 4;
    private static final int LADDER_HEIGHT = 3;
    private static final List<Boolean> TFT_ROW = List.of(
            true, false, true,
            true, false, true,
            true, false, true
    );

    @Test
    void 사다리_실행_결과의_위치에_있는_상품을_플레이어에게_매칭한다() {
        Ladder ladder = Ladder.of(LADDER_WIDTH, LADDER_HEIGHT, new TestConnectionGenerator(TFT_ROW));
        Players players = Players.from(List.of("pobi", "crong", "loopy", "eddy"));
        List<String> prize = List.of("crocodile", "bear", "fox", "beaver");
        LadderGame ladderGame = new LadderGame(ladder, players);
        Map<String, String> gameResult = ladderGame.play(prize);

        assertThat(gameResult).isEqualTo(Map.of(
                "pobi", "bear",
                "crong", "crocodile",
                "loopy", "beaver",
                "eddy", "fox"
        ));
    }
}
