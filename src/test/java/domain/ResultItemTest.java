package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultItemTest {

    @Test
    @DisplayName("정상적인 값이 주어졌을 때, ResultItem이 생성되어야 한다.")
    void create() {
        ResultItem resultItem = new ResultItem("1등");
        assertEquals("1등", resultItem.getItem());
    }

    @Test
    @DisplayName("값이 비어 있을 경우 예외가 발생해야 한다.")
    void emptyThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResultItem("");
        });
        assertEquals("실행 결과 값은 필수 입력 값입니다.", exception.getMessage());
    }
}
