package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayersTest {

    @Test
    void 플레이어_이름_목록으로_Players를_생성한다() {
        Players players = Players.from(List.of("pobi", "crong"));

        assertThat(players.getPlayerNames()).isEqualTo(List.of("pobi", "crong"));
    }

    @Test
    void 플레이어의_이름은_중복될_수_없다() {
        assertThatThrownBy(() -> Players.from(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
