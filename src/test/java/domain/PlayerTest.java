package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {
    @Test
    void 이름이_5자_초과되면_예외처리된다() {
        assertThatThrownBy(() -> new Player("abcdef", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 5글자 이하입니다.");
    }

    @Test
    void 이름을_입력하지_않으면_예외처리된다() {
        assertThatThrownBy(() -> new Player("", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름이 입력되지 않았습니다.");
    }
}
