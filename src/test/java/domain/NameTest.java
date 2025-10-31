package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    void 이름_공백제거_확인() {
        //given
        String input = " 태우";

        //when
        Name name = new Name(input);

        //then
        assertThat(name.value()).isEqualTo("태우");
    }

    @Test
    void 빈문자열_예외확인() {
        //given
        String input = " ";

        //when & then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 동일한_이름일시_True_반환() {
        //given
        Name n1 = new Name("태우");
        Name n2 = new Name("태우");

        //when & then
        assertThat(n1).isEqualTo(n2);
        assertThat(n1.hashCode()).isEqualTo(n2.hashCode());
    }
}
