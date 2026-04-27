package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    private static final int MAX_LENGTH = 5;

    @Test
    void 플레이어_이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Player("sixchar"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 " + MAX_LENGTH + "글자");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 플레이어_이름이_비어있거나_공백이면_예외가_발생한다(String source) {
        assertThatThrownBy(() -> new Player(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어 있거나 공백일 수 없습니다.");
    }
}
