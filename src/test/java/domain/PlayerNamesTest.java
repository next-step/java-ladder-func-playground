package domain;

import domain.user.PlayerName;
import domain.user.PlayerNames;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerNamesTest {

    @Test
    void 플레이어_목록에서_인덱스로_조회된다() {
        PlayerNames names = new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b")));
        assertEquals("a", names.get(0).getName());
    }

    @Test
    void 플레이어_존재_여부를_확인할_수_있다() {
        PlayerName name = new PlayerName("a");
        PlayerNames names = new PlayerNames(List.of(name));
        assertTrue(names.contains(name));
    }

    @Test
    void 인덱스_리스트를_반환한다() {
        PlayerNames names = new PlayerNames(List.of(new PlayerName("a"), new PlayerName("b")));
        assertEquals(List.of(0, 1), names.toIntegerList());
    }
}
