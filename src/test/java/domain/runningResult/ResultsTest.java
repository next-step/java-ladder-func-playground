package domain.runningResult;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("실행 결과가 입력되면 정상적으로 객체를 생성한다.")
    void shouldCreateResults_whenValidInputValues() {
        // given
        List<String> inputValues = List.of("4000", "꽝", "3000");

        // when
        Results results = Results.from(inputValues);

        // then
        List<String> actual = results.asList().stream()
                .map(Result::value)
                .toList();

        assertThat(actual).isEqualTo(inputValues);
    }

}
