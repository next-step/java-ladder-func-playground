package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("여러 Line의 move를 순서대로 적용해 최종 위치를 계산한다")
    @Test
    void getDestination() {
        // given
        Line line1 = Line.of(List.of(0), 3);
        Line line2 = Line.of(List.of(1), 3);
        Ladder ladder = new Ladder(List.of(line1, line2));

        // when
        int result = ladder.getDestination(0);

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("단일 라인에서 다리를 통해 이동한 위치를 반환한다")
    @Test
    void getDestinationWithSingleLine() {
        // given
        Line line = Line.of(List.of(0), 3);
        Ladder ladder = new Ladder(List.of(line));

        // when
        int result = ladder.getDestination(0);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("복잡한 사다리에서 모든 시작 위치의 도착 위치를 올바르게 계산한다")
    @Test
    void getDestinationForAllPositions() {
        // given
        Line line1 = Line.of(List.of(0, 2), 4);
        Line line2 = Line.of(List.of(1), 4);
        Ladder ladder = new Ladder(List.of(line1, line2));

        // when & then
        assertThat(ladder.getDestination(0)).isEqualTo(2);
        assertThat(ladder.getDestination(1)).isEqualTo(0);
        assertThat(ladder.getDestination(2)).isEqualTo(3);
        assertThat(ladder.getDestination(3)).isEqualTo(1);
    }

}
