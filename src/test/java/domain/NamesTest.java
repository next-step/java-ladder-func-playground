package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {
    @Test
    void 쉼표로_구분된_문자열_생성() {
        //given
        String input = "태우1,태우2";

        //when
        Names names = new Names(input);

        //then
        assertThat(names.size()).isEqualTo(2);
        assertThat(names.getValues())
                .extracting(Name::value)
                .containsExactly("태우1", "태우2");
    }
}
