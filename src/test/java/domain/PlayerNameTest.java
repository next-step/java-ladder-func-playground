package domain;

import domain.user.PlayerName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerNameTest {

    @Test
    void 이름이_null이면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(null));
    }

    @Test
    void 이름이_빈문자열이면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(" "));
    }

    @Test
    void 이름이_다섯자를_초과하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("abcdef"));
    }

    @Test
    void 정상적인_이름은_생성된다() {
        PlayerName name = new PlayerName("abc");
        assertEquals("abc", name.getName());
    }
}
