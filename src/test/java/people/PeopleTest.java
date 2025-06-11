package people;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {
    @Test
    @DisplayName("중복된 이름이 없는 경우 정상적으로 People이 생성된다")
    void createPeopleWithoutDuplicateNames() {
        List<String> names = List.of("neo", "brown", "brie");
        People people = People.from(names);

        assertThat(people.size()).isEqualTo(3);
        assertThat(people.values()).extracting(Person::name)
                .containsExactly("neo", "brown", "brie");
    }

    @Test
    @DisplayName("중복된 이름이 있으면 예외가 발생한다")
    void throwsExceptionWhenDuplicateNames() {
        List<String> names = List.of("neo", "brown", "neo");

        assertThatThrownBy(() -> People.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("contains는 해당 이름이 있으면 true, 없으면 false를 반환한다")
    void containsWorksProperly() {
        People people = People.from(List.of("neo", "brown", "brie"));

        assertThat(people.contains("neo")).isTrue();
        assertThat(people.contains("brie")).isTrue();
        assertThat(people.contains("tommy")).isFalse();
    }

    @Test
    @DisplayName("indexOf는 이름의 인덱스를 올바르게 반환한다")
    void indexOfWorksProperly() {
        People people = People.from(List.of("neo", "brown", "brie"));

        assertThat(people.indexOf("neo")).isEqualTo(0);
        assertThat(people.indexOf("brown")).isEqualTo(1);
        assertThat(people.indexOf("brie")).isEqualTo(2);
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 indexOf를 호출하면 예외가 발생한다")
    void indexOfThrowsExceptionWhenNameNotFound() {
        People people = People.from(List.of("neo", "brown", "brie"));

        assertThatThrownBy(() -> people.indexOf("tommy"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 이름입니다.");
    }
}

