package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("유효한 플레이어 리스트로 객체가 제대로 생성되는지 검증한다.")
    void shouldNotThrowExceptionWhenValidPlayers() {
        List<String> validPlayerNames = List.of("Alice", "Bob");

        Players players = new Players(validPlayerNames);

        assertThat(players.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("플레이어 수가 부족하면 예외가 발생하는지 검증한다.")
    void shouldThrowExceptionWhenNotEnoughPlayers() {
        List<String> invalidPlayerNames = List.of("Alice");

        assertThatThrownBy(() -> new Players(invalidPlayerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이여야 합니다.");
    }

    @Test
    @DisplayName("플레이어 수가 충분하면 객체가 제대로 생성되는지 검증한다.")
    void shouldContainValidPlayersWhenGenerated() {
        List<String> validPlayerNames = List.of("Alice", "Bob");

        Players players = new Players(validPlayerNames);

        assertThat(players.getPlayers()).containsExactly("Alice", "Bob");
    }
}
