package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderWidthTest {

    @DisplayName("유효한 사다리 너비(2명 이상)로 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 100})
    void createWidth(int value) {
        LadderWidth width = LadderWidth.from(value);
        assertThat(width.getValue()).isEqualTo(value);
    }

    @DisplayName("사다리 너비가 2 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -5})
    void invalidWidth(int value) {
        assertThatThrownBy(() -> LadderWidth.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여할 사람은 최소 2명 이상이어야 합니다.");
    }
}
