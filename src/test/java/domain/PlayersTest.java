package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayersTest {

    @Test
    void 플레이어의_이름은_중복될_수_없다() {
        assertThatThrownBy(() -> Players.of(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
