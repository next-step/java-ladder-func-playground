package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final List<String> NAMES_3 = List.of("p1", "p2", "p3");
    private static final List<String> NAMES_4 = List.of("p1", "p2", "p3", "p4");

    @DisplayName("설정한 높이만큼 사다리의 가로 줄(Line)이 생성된다.")
    @Test
    void createLadder_HeightCheck() {
        int heightValue = 5;
        Ladder ladder = createLadder(NAMES_3, heightValue);

        // then
        assertThat(ladder.getLines()).hasSize(heightValue);
    }

    @DisplayName("각 가로 줄(Line)은 사람 수보다 1개 적은 포인트(Point)를 가진다.")
    @Test
    void createLadder_WidthCheck() {
        Ladder ladder = createLadder(NAMES_4, 3);

        assertThat(ladder.getLines()).allSatisfy(line -> {
            assertThat(line.getPoints()).hasSize(NAMES_4.size() - 1);
        });
    }

    @DisplayName("주입된 전략에 따라 사다리 내부의 다리들이 규칙적으로 생성된다.")
    @Test
    void createLadder_StrategyCheck() {
        Ladder ladder = createLadder(NAMES_3, 1);
        Line firstLine = ladder.getLines().get(0);
        Points points = firstLine.getPoints();

        assertAll(
            () -> assertThat(points.get(0).hasBridge()).isTrue(),
            () -> assertThat(points.get(1).hasBridge()).isFalse()
        );
    }

    @DisplayName("사다리를 타고 내려가 최종 도착 지점의 인덱스를 반환한다.")
    @Test
    void climb() {
        Ladder ladder = createLadder(List.of("p1", "p2"), 1);

        assertAll(
            () -> assertThat(ladder.climb(0)).isEqualTo(1),
            () -> assertThat(ladder.climb(1)).isEqualTo(0)
        );
    }

    @DisplayName("사다리 전체 실행 결과를 Map 형태로 반환한다.")
    @Test
    void generateResults() {
        Ladder ladder = createLadder(NAMES_3, 1);

        Map<Integer, Integer> results = ladder.generateResults();

        assertAll(
            () -> assertThat(results).hasSize(NAMES_3.size()),
            () -> assertThat(results.get(0)).isEqualTo(1),
            () -> assertThat(results.get(1)).isEqualTo(0),
            () -> assertThat(results.get(2)).isEqualTo(2)
        );
    }

    private Ladder createLadder(List<String> names, int height) {
        Participants participants = Participants.from(names);
        LadderHeight ladderHeight = LadderHeight.from(height);

        Lines lines = Lines.generate(participants.size(), ladderHeight, () -> true);

        return Ladder.of(participants, lines);
    }
}
