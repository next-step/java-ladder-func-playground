package domain;

import domain.prize.PrizeName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeNameTest {

    @Test
    void 유효한_결과는_생성된다() {
        assertDoesNotThrow(() -> new PrizeName("5000"));
    }

    @Test
    void 결과는_공백일_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new PrizeName(" "));
    }

    @Test
    void 결과는_null이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PrizeName(null));
    }

    @Test
    void 결과는_최대_5글자() {
        assertThrows(IllegalArgumentException.class, () -> new PrizeName("123456"));
    }
}
