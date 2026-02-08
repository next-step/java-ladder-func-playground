package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameResultTest {

    private Participants participants;
    private LadderResults results;
    private Map<Integer, Integer> ladderPath;

    @BeforeEach
    void setUp() {
        participants = Participants.from(List.of("jin", "park"));
        results = LadderResults.of(List.of("win", "lose"), 2);

        ladderPath = Map.of(0, 1, 1, 0);
    }

    @DisplayName("사다리 경로에 따라 이름과 결과가 올바르게 매핑된다.")
    @Test
    void mapResults_Success() {
        // when
        LadderGameResult gameResult = LadderGameResult.of(participants, results, ladderPath);

        // then
        assertThat(gameResult.getResultByName("jin")).isEqualTo("lose");
        assertThat(gameResult.getResultByName("park")).isEqualTo("win");
    }

    @DisplayName("존재하지 않는 이름으로 결과를 조회하면 예외가 발생한다.")
    @Test
    void getResult_InvalidName_Exception() {
        // given
        LadderGameResult gameResult = LadderGameResult.of(participants, results, ladderPath);

        // then
        assertThatThrownBy(() -> gameResult.getResultByName("hyeong"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("해당 이름의 참가자가 없습니다.");
    }

    @DisplayName("전체 결과 조회 시 모든 매핑 정보가 포함되어야 한다.")
    @Test
    void getAllResults_Success() {
        // given
        LadderGameResult gameResult = LadderGameResult.of(participants, results, ladderPath);

        // when
        Map<Name, LadderResult> allResults = gameResult.getAllResults();

        // then
        assertThat(allResults).hasSize(2);
        Name jin = participants.getValues().get(0);
        assertThat(allResults.get(jin).getValue()).isEqualTo("lose");
    }
}
