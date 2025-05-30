import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class NameTest {
    @Test
    @DisplayName("이름 값 반환")
    void getValue() {
        Name name = new Name("홍길동");
        assertThat(name.getValue()).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("같은 이름을 가진 Name 객체는 동등")
    void equalsWithSameName() {
        Name name1 = new Name("홍길동");
        Name name2 = new Name("홍길동");

        assertThat(name1).isEqualTo(name2);
    }

    @Test
    @DisplayName("다른 이름을 가진 Name 객체는 동등하지 않음")
    void equalsWithDifferentName() {
        Name name1 = new Name("홍길동");
        Name name2 = new Name("김철수");

        assertThat(name1).isNotEqualTo(name2);
    }
}
