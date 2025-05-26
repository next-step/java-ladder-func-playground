package domain;

import static domain.Ladder.ERROR_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리 크기는 1 이상이어야한다.")
    @Test
    void createInvalidLadder() {
        assertThatThrownBy(() -> Ladder.generate(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_SIZE);
    }
}