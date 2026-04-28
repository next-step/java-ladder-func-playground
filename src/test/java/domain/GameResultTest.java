package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    @Test
    @DisplayName("이름으로 결과를 찾을 수 있다.")
    void findByName() {
        Player player = new Player(new PlayerName("neo"), new Reward("꽝"));
        GameResult gameResult = new GameResult(Arrays.asList(player));

        assertThat(gameResult.findByName("neo").getReward().getValue()).isEqualTo("꽝");
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 검색 시 예외가 발생한다.")
    void findByName_Fail() {
        GameResult gameResult = new GameResult(Arrays.asList());

        assertThatThrownBy(() -> gameResult.findByName("none"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}