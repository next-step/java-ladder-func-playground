package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @DisplayName("유효한 사다리 높이로 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void createHeight(int value) {
        LadderHeight height = LadderHeight.from(value);
        assertThat(height.getValue()).isEqualTo(value);
    }

    @DisplayName("사다리 높이가 1 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void invalidHeight(int value) {
        assertThatThrownBy(() -> LadderHeight.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여할 사람은 최소 2명 이상이어야 합니다.");
    }

}
