package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    void 쉼표로_구분된_문자열_생성() {
        //given
        String input = "꽝,5000,꽝";

        //when
        Results results = new Results(input);

        //then
        assertThat(results.size()).isEqualTo(3);
        assertThat(results.getResults().getValues())
                .extracting(Name::value)
                .containsExactly("꽝", "5000", "꽝");
    }
}
