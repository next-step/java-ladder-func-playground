package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersTest {

    @Test
    @DisplayName("주어진 사다리 개수만큼 사다리를 생성할 수 있다.")
    void createInitialLaddersTest() {
        // given
        int countOfLadders = 6;
        // when
        final Ladders ladders = Ladders.from(countOfLadders);
        // then
        assertThat(ladders.getCountOfLadders())
            .isEqualTo(countOfLadders);
    }

}
