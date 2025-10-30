package participant;

import model.participant.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    @DisplayName("플레이어 이름이 1~5 글자가 아니면 예외가 발생한다")
    void validatePlayerNameLength() {
        String playerName1 = "longName";
        String playerName2 = "";

        assertThrows(IllegalArgumentException.class, () -> new Player(playerName1));
        assertThrows(IllegalArgumentException.class, () -> new Player(playerName2));
    }

    @Test
    @DisplayName("플레이어 이름이 null이면 예외가 발생한다")
    void validatePlayerNameNull() {
        String playerName = null;

        assertThrows(IllegalArgumentException.class, () -> new Player(playerName));
    }

    @Test
    @DisplayName("유효한 이름으로 플레이어가 생성된다")
    void createPlayerSuccessfully() {
        String name = "neo";

        Player player = new Player(name);

        assertThat(player).isNotNull();
        assertThat(player.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("같은 이름을 가진 Player 객체는 동등하다")
    void testPlayerEquality() {
        Player player1 = new Player("neo");
        Player player2 = new Player("neo");
        Player player3 = new Player("brown");


        assertThat(player1).isEqualTo(player2);
        assertThat(player1.hashCode()).isEqualTo(player2.hashCode());
        assertThat(player1).isNotEqualTo(player3);
    }
}
