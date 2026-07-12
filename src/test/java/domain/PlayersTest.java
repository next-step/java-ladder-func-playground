package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {

    @Test
    @DisplayName("정상적인 플레이어 목록으로 생성된다.")
    void create() {
        List<Player> playerList = List.of(new Player("Tom"), new Player("Jerry"), new Player("Max"));
        Players players = new Players(playerList);

        assertEquals(3, players.count());
    }

    @Test
    @DisplayName("플레이어 수가 0명일 경우 예외가 발생해야 한다.")
    void emptyThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Players(List.of());
        });
        assertEquals("참여 인원은 최소 1명 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("플레이어의 이름 목록을 정확히 추출한다.")
    void extractNames() {
        List<Player> playerList = List.of(new Player("Tom"), new Player("Jerry"), new Player("Max"));
        Players players = new Players(playerList);

        List<String> names = players.extractNames();
        assertEquals(List.of("Tom", "Jerry", "Max"), names);
    }

    @Test
    @DisplayName("플레이어 객체 목록을 정확히 반환한다.")
    void extractPlayers() {
        List<Player> playerList = List.of(new Player("Tom"), new Player("Jerry"), new Player("Max"));
        Players players = new Players(playerList);

        List<Player> extractedPlayers = players.extractPlayers();
        assertEquals(3, extractedPlayers.size());
        assertEquals(playerList, extractedPlayers);

        assertThrows(UnsupportedOperationException.class, () -> {
            extractedPlayers.add(new Player("John"));
        });
    }
}
