package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("이름 생성 성공")
    void create_name() {
        Name name = new Name("pobi");
        assertThat(name.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "      ", "sixchar"})
    @DisplayName("이름이 빈값이거나 5자를 초과하면 예외 발생")
    void invalid_name(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
