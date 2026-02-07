package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("설정한 높이만큼 사다리의 가로 줄(Line)이 생성된다.")
    @Test
    void createLadder_HeightCheck() {
        // given
        LadderWidth width = LadderWidth.from(3);
        LadderHeight height = LadderHeight.from(5);

        // when
        Ladder ladder = Ladder.of(width, height, () -> true);

        // then
        assertThat(ladder.getLines()).hasSize(5);
    }

    @DisplayName("각 가로 줄(Line)은 사람 수보다 1개 적은 포인트(Point)를 가진다.")
    @Test
    void createLadder_WidthCheck() {
        // given
        int personCount = 4;
        LadderWidth width = LadderWidth.from(personCount);
        LadderHeight height = LadderHeight.from(3);

        // when
        Ladder ladder = Ladder.of(width, height, () -> true);

        // then
        assertThat(ladder.getLines()).allSatisfy(line -> {
            assertThat(line.getPoints()).hasSize(3);
        });
    }

    @DisplayName("주입된 전략에 따라 사다리 내부의 다리들이 규칙적으로 생성된다.")
    @Test
    void createLadder_StrategyCheck() {
        // given
        LadderWidth width = LadderWidth.from(3); // 포인트 2개
        LadderHeight height = LadderHeight.from(1);

        // when
        Ladder ladder = Ladder.of(width, height, () -> true);
        Line firstLine = ladder.getLines().get(0);

        // then
        assertAll(
            () -> assertThat(firstLine.getPoints().get(0).hasBridge()).isTrue(),
            () -> assertThat(firstLine.getPoints().get(1).hasBridge()).isFalse()
        );
    }

}
