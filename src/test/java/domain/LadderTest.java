package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 전체를 타고 내려갔을 때의 최종 위치 확인")
    void ladder_climb() {
        // 2x2 크기의 고정된 사다리 생성 전략
        LadderRowStrategy fixStrategy = count -> Arrays.asList(
                new LadderStep(0, false, true),
                new LadderStep(1, true, false)
        );

        Ladder ladder = new Ladder(2, 2, fixStrategy);

        // 두 줄 모두 교차하므로 0 -> 1 -> 0 (최종 0)
        // 0 -> 1 (첫번째 줄) -> 0 (두번째 줄)
        assertThat(ladder.climb(0)).isEqualTo(0);
        assertThat(ladder.climb(1)).isEqualTo(1);
    }
}
