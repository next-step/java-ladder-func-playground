package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    @DisplayName("플레이어의 수가 기준을 준수하지 않았을 시 예외가 발생한다.")
    void shouldThrowException_whenInvalidPlayerSize(int size) {
        // given
        List<String> names = IntStream.range(0, size)
                .mapToObj(i -> "dd" + i)
                .toList();

        // when & then
        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 수는 2 이상 24 이하여야 합니다.");
    }

    @Test
    @DisplayName("플레이어의 이름이 중복되었을 경우 예외가 발생한다.")
    void shouldThrowException_whenDuplicatePlayerNames() {
        // given
        List<String> duplicateNames = List.of("dd", "pobi", "dd");

        // when & then
        assertThatThrownBy(() -> Players.from(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 중복이 아니어야 합니다.");
    }
}
