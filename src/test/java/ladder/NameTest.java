package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름 정상 입력")
    void generateName() {
        assertThatNoException().isThrownBy(() -> new Name("pobi"));
    }

    @Test
    @DisplayName("이름 5글자 초과시 예외발생")
    void overLengthName() {
        assertThatThrownBy(() -> new Name("pobiii"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 최대 5글자까지 가능합니다.");
    }
}
