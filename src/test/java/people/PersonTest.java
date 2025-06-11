package people;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    @DisplayName("이름이 null이면 예외가 발생한다")
    void throwsExceptionWhenNameIsNull() {
        assertThatThrownBy(() -> Person.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 빈 문자열 또는 공백만 있으면 예외가 발생한다")
    void throwsExceptionWhenNameIsBlank() {
        assertThatThrownBy(() -> Person.from(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");

        assertThatThrownBy(() -> Person.from("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다")
    void throwsExceptionWhenNameIsTooLong() {
        assertThatThrownBy(() -> Person.from("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는");
    }

    @Test
    @DisplayName("정상적으로 생성된 Person은 name 값을 가진다")
    void createPersonSuccessfully() {
        Person person = Person.from("neo");
        assertThat(person.name()).isEqualTo("neo");
    }

    @Test
    @DisplayName("isSameName은 값이 같으면 true, 다르면 false를 반환한다")
    void isSameNameWorksProperly() {
        Person person = Person.from("neo");
        assertThat(person.isSameName("neo")).isTrue();
        assertThat(person.isSameName("brown")).isFalse();
    }
}