package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    void 플레이어_리스트를_생성할_수_있다() {
        // given
        List<PlayerName> list = List.of(new PlayerName("태우1"), new PlayerName("태우2"));

        // when
        Players players = new Players(list);

        // then
        assertThat(players.size()).isEqualTo(2);
    }

    @Test
    void 중복된_이름이_있으면_예외() {
        // given
        List<PlayerName> list = List.of(new PlayerName("태우"), new PlayerName("태우"));

        // when & then
        assertThatThrownBy(() -> new Players(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
