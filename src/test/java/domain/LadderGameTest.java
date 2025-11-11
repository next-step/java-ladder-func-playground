package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    void 참가자와_결과_수_불일치() {
        //given
        Players players = new Players(List.of(new PlayerName("태우"), new PlayerName("태우1")));
        Results results = new Results(List.of(new ResultName("꽝")));

        //when & then
        assertThatThrownBy(() -> LadderGame.validatePlayerAndResultCount(players, results))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 참가자_이름으로_결과를_조회할_수_있다() {
        //given
        Players players = new Players(List.of(new PlayerName("태우"), new PlayerName("태우1")));
        Results results = new Results(List.of(new ResultName("꽝"), new ResultName("5000")));
        int height = 2;
        Ladder ladder = new Ladder(height, players.size(), new Random(1));
        LadderGame game = new LadderGame(ladder, players, results);

        //when
        String result1 = game.findResultByPlayer("태우");
        String result2 = game.findResultByPlayer("태우1");

        //then
        assertThat(result1).isIn("꽝", "5000");
        assertThat(result2).isIn("꽝", "5000");
    }

    @Test
    void all_입력시_모든_참가자와_그_결과가_나온다() {
        //given
        Players players = new Players(List.of(new PlayerName("태우"), new PlayerName("태우1")));
        Results results = new Results(List.of(new ResultName("꽝"), new ResultName("5000")));
        int height = 2;
        Ladder ladder = new Ladder(height, players.size(), new Random(1));
        LadderGame game = new LadderGame(ladder, players, results);

        //when
        Map<String, String> map = game.findAll();

        //then
        assertThat(map.keySet()).containsExactlyInAnyOrder("태우", "태우1");
        assertThat(map.values()).containsExactlyInAnyOrder("꽝", "5000");
    }

    @Test
    void 존재하지_않는_플레이어_조회시_예외() {
        //given
        Players players = new Players(List.of(new PlayerName("태우"), new PlayerName("태우1")));
        Results results = new Results(List.of(new ResultName("꽝"), new ResultName("5000")));
        int height = 2;
        Ladder ladder = new Ladder(height, players.size(), new Random(1));
        LadderGame game = new LadderGame(ladder, players, results);

        // when & then
        assertThatThrownBy(() -> game.findResultByPlayer("철수"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
