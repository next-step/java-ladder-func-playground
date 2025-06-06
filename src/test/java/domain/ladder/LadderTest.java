package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Line;
import domain.Point;
import domain.Width;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedLineGenerator;
import strategy.LineGenerator;

class LadderTest {

    @Test
    @DisplayName("시작 인덱스에서 사다리를 타고 이동한 최종 인덱스를 반환한다.")
    void shouldReturnIndex_whenMoveLadder() {
        // given
        LineGenerator generator = new FixedLineGenerator(List.of(
                new boolean[]{true, false, false},
                new boolean[]{false, false, false},
                new boolean[]{false, true, false}
        ));

        List<Line> lines = List.of(
                generator.generate(3),
                generator.generate(3),
                generator.generate(3)
        );

        Ladder ladder = Ladder.from(lines);

        // when & then
        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리의 모든 인접 라인이 적어도 하나 이상 연결되어 있는지 확인한다.")
    void shouldCheckIsFullyConnected() {
        // given
        List<Line> lines = List.of(
                Line.from(List.of(Point.from(true), Point.from(false))),
                Line.from(List.of(Point.from(false), Point.from(true)))
        );

        Ladder ladder = Ladder.from(lines);

        // when & then
        assertThat(ladder.isFullyConnected(Width.from(3))).isTrue();
    }

    @Test
    @DisplayName("사다리의 인접한 라인 중 연결되지 않은 곳이 있는지 확인한다.")
    void shouldCheckIsNotFullyConnected() {
        // given
        List<Line> lines = List.of(
                Line.from(List.of(Point.from(false), Point.from(false))),
                Line.from(List.of(Point.from(false), Point.from(false)))
        );

        Ladder ladder = Ladder.from(lines);

        // when & then
        assertThat(ladder.isFullyConnected(Width.from(3))).isFalse();
    }

    @Test
    @DisplayName("반환된 리스트는 수정 불가능하다.")
    void shouldReturnUnmodifiableList() {
        // given
        List<Line> lines = List.of(Line.from(List.of(Point.from(true))));
        Ladder ladder = Ladder.from(lines);

        // when & then
        assertThatThrownBy(() -> ladder.getLines().add(Line.from(List.of(Point.from(false)))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
