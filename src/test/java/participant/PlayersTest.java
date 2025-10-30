package participant;

import model.participant.Player;
import model.participant.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("Players가 플레이어 수와 객체를 올바르게 반환한다")
    void playersCollectionTest() {
        Player neo = new Player("neo");
        Player brown = new Player("brown");
        List<Player> playerList = List.of(neo, brown);
        Players players = new Players(playerList);

        assertThat(players.size()).isEqualTo(2);

        assertThat(players.getPlayerAt(0)).isEqualTo(neo);
        assertThat(players.getPlayerAt(1)).isEqualTo(brown);

        assertThat(players.getPlayers()).containsExactly(neo, brown);
    }
}
