package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void getResult() {
        Players players = new Players(List.of(
                new Player("neo"),
                new Player("brown"),
                new Player("brie"),
                new Player("tommy")
        ));
        Rewards rewards = new Rewards(List.of("꽝", "5000", "꽝", "3000"));
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );
        Ladder ladder = new Ladder(lines);
        LadderResult result = new LadderResult(ladder, players, rewards);

        assertThat(result.getResult("neo")).isEqualTo("꽝");
    }
}