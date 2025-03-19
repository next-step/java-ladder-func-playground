package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("유효한 이름으로 플레이어가 정상적으로 생성된다.")
    void shouldCreatePlayerCorrectlyWhenNameIsValid() {
        String validName = "Alice";

        Player player = new Player(validName);

        assertThat(player.getValue()).isEqualTo(validName);
    }

    @Test
    @DisplayName("플레이어 이름이 최대 길이를 초과하면 예외가 발생한다.")
    void shouldThrowExceptionWhenNameMaxLength() {
        String invalidName = "LongName";

        assertThatThrownBy(() -> new Player(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 5글자를 초과할 수 없습니다.");
    }
}
