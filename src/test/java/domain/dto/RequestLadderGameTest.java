package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RequestLadderTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 높이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyHeight(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadder(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 넓이와 높이를 입력해야 합니다.");
    }

    @Test
    @DisplayName("유효한 넓이와 높이를 입력하면 올바르게 객체가 생성된다.")
    void shouldReturnCorrectWidthAndHeight() {
        // given
        RequestLadder requestLadder = new RequestLadder("7");

        // when
        Height height = requestLadder.toHeight();

        // then
        assertThat(height.value()).isEqualTo(7);
    }
}
