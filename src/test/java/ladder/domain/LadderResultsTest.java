package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultsTest {

    @DisplayName("참가자 수와 결과의 개수가 일치하면 정상적으로 생성된다.")
    @Test
    void create_Success() {
        // given
        List<String> rawResults = List.of("꽝", "5000", "3000");
        int participantCount = 3;

        // when
        LadderResults ladderResults = LadderResults.of(rawResults, participantCount);

        // then
        assertThat(ladderResults.getValues()).hasSize(3);
        assertThat(ladderResults.getValues().get(0).getValue()).isEqualTo("꽝");
    }

    @DisplayName("참가자 수와 결과의 개수가 다르면 예외가 발생한다.")
    @Test
    void create_SizeMismatch_Exception() {
        // given
        List<String> rawResults = List.of("꽝", "5000");
        int participantCount = 3;

        // then
        assertThatThrownBy(() -> LadderResults.of(rawResults, participantCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참가자 수와 결과의 개수가 일치해야 합니다.");
    }
}
