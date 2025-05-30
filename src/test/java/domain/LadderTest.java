package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        int width = 4;
        int height = 4;

        // when
        Ladder ladder = Ladder.create(width, height, () -> false);

        // then
        assertThatThrownBy(() -> {
            int modifiedWidth = 2;
            ladder.getLines().add(Line.create(modifiedWidth, () -> true));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
