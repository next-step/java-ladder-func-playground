package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    void 결과_리스트를_생성할_수_있다() {
        // given
        List<ResultName> list = List.of(new ResultName("태우1"), new ResultName("태우2"));

        // when
        Results results = new Results(list);

        // then
        assertThat(results.size()).isEqualTo(2);
    }
}
