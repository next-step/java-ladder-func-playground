package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderGeneratorTest {
    @Test
    void 존재하는_이름으로_검색하면_해당_플레이어를_반환한다() {
        Player pobi = new Player(new PlayerName("pobi"), new Reward("꽝"));
        GameResult gameResult = new GameResult(List.of(pobi));

        assertThat(gameResult.findByName("pobi")).isEqualTo(pobi);
    }

    @Test
    void 존재하지_않는_이름으로_검색하면_예외가_발생한다() {
        Player pobi = new Player(new PlayerName("pobi"), new Reward("꽝"));
        GameResult gameResult = new GameResult(List.of(pobi));

        assertThatThrownBy(() -> gameResult.findByName("crong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 사람입니다.");
    }

}