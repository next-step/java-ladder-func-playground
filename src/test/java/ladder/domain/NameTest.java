package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @DisplayName("1자 이상 5자 이하의 이름은 정상적으로 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"jin", "hyeon", "soo"})
    void createName_Success(String input) {
        Name name = Name.from(input);
        assertThat(name.getName()).isEqualTo(input);
    }

    @DisplayName("이름 앞뒤에 공백이 있을 경우 제거(trim) 후 저장한다.")
    @Test
    void createName_Trim() {
        Name name = Name.from("  jin ");
        assertThat(name.getName()).isEqualTo("jin");
    }

    @DisplayName("이름이 null이거나 빈 문자열, 혹은 공백만 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void createName_Blank_Exception(String input) {
        assertThatThrownBy(() -> Name.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 빈 값일 수 없습니다.");
    }

    @DisplayName("이름이 5자를 초과하면 예외가 발생한다.")
    @Test
    void createName_OverLength_Exception() {
        assertThatThrownBy(() -> Name.from("sixchar"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자입니다.");
    }

}
