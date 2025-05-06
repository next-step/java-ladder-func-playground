package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이가 정상적으로 생성된다")
    void 사다리_높이가_정상적으로_생성된다() {
        //given
        LadderHeight ladderHeight = new LadderHeight(1);

        //when
        int height = ladderHeight.height();

        //then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 높이가 0이하면 예외를 던진다")
    void 사다리_높이가_0이하면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
