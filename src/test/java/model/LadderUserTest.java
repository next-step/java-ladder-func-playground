package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderUserTest {

    private static final List<String> ILLEGAL_NAMES = List.of("all");

    @ParameterizedTest
    @DisplayName("인스턴스를 생성할 때 전달된 name을 반환한다")
    @ValueSource(strings = {"A", "B", "C", "D", "E"})
    void getName(String name) {
        LadderUser ladderUser = new LadderUser(name);
        String actualResult = ladderUser.getName();

        assertThat(actualResult).isEqualTo(name);
    }

    @Test
    @DisplayName("사용할 수 없는 이름을 전달하면 예외가 발생한다")
    void ifUseIllegalNameThenThrowException() {
        for (String illegalName : ILLEGAL_NAMES) {
            assertThatThrownBy(() -> new LadderUser(illegalName))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @DisplayName("너무 긴 이름을 전달하면 예외가 발생한다")
    @ValueSource(strings = {
            "123456",
            "1234567",
            "abcdefgh"
    })
    void ifUseTooLongNameThenThrowException(String illegalName) {
        assertThatThrownBy(() -> new LadderUser(illegalName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("빈 이름을 전달하면 예외가 발생한다")
    @ValueSource(strings = {"", " ", "  "})
    void ifUseEmptyNameThenThrowException(String emptyName) {
        assertThatThrownBy(() -> new LadderUser(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
