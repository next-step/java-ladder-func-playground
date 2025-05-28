package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 시, row 수만큼 Line이 생성되어야 한다")
    void ShouldCreateLinesEqualToRowCount() {
        // given
        int rowCount = 4;
        int columnCount = 3;

        // when
        Ladder ladder = new Ladder(rowCount, columnCount);

        // then
        List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(rowCount);
    }

    @Test
    @DisplayName("generateLadder 호출 시, 최소 하나 이상의 Link가 연결되어야 한다")
    void ShouldGenerateAtLeastOneLinkWhenLadderIsInitialized() {
        // given
        int rowCount = 3;
        int columnCount = 4;
        Ladder ladder = new Ladder(rowCount, columnCount);

        // when
        ladder.generateLadder();

        // then
        boolean atLeastOneLinked = ladder.getLines().stream()
                .flatMap(line -> line.getLinks().stream())
                .anyMatch(link -> link.isLinked());

        assertThat(atLeastOneLinked).isTrue();
    }
}