package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("정상적인 이름이 주어졌을 때, 플레이어가 생성되어야 한다.")
    void create() {
        Player player = new Player("Tom");
        assertEquals("Tom", player.getName());
    }

    @Test
    @DisplayName("이름이 비어 있을 경우 예외가 발생해야 한다.")
    void emptyNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Player("");
        });
        assertEquals("참여할 사람의 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생해야 한다.")
    void longNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Player("TommyLee");
        });
        assertEquals("참여할 사람의 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("다른 이름의 플레이어를 서로 다른 플레이어(객체)로 판단해야 한다.")
    void playersWithDifferentNamesShouldNotBeEqual() {
        Player player1 = new Player("Tom");
        Player player2 = new Player("Jerry");

        assertNotEquals(player1, player2);
    }
}
