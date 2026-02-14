package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @DisplayName("참가자 수와 높이에 맞는 라인 묶음이 생성된다.")
    @Test
    void createLines() {
        int participantCount = 4;
        int height = 5;
        Lines lines = Lines.generate(participantCount, LadderHeight.from(height), () -> false);

        assertAll(
            () -> assertThat(lines.size()).isEqualTo(height),
            () -> assertThat(lines.get(0).getPoints().size()).isEqualTo(participantCount - 1)        );
    }

    @DisplayName("다리가 하나도 없을 때, 시작 인덱스와 도착 인덱스는 동일하다.")
    @Test
    void move_noBridge() {
        // given
        Lines lines = Lines.generate(3, LadderHeight.from(3), () -> false);

        assertAll(
            () -> assertThat(lines.move(0)).isEqualTo(0),
            () -> assertThat(lines.move(1)).isEqualTo(1),
            () -> assertThat(lines.move(2)).isEqualTo(2)
        );
    }

    @DisplayName("다리가 모든 층에 가로로 놓여있을 때, 인덱스가 지그재그로 이동한다.")
    @Test
    void move_withBridges() {
        // given: 2명이 참여하고 1층 높이인데 다리가 있는 경우
        Lines lines = Lines.generate(2, LadderHeight.from(1), () -> true);

        assertThat(lines.move(0)).isEqualTo(1);
        assertThat(lines.move(1)).isEqualTo(0);
    }

    @DisplayName("여러 층을 거쳐 최종 위치를 정확히 계산한다.")
    @Test
    void move_multipleFloors() {
        // given: 2명이 참여하고 2층 높이인데 모든 층에 다리가 있는 경우 (0 -> 1 -> 0)
        Lines lines = Lines.generate(2, LadderHeight.from(2), () -> true);

        // then
        assertThat(lines.move(0)).isEqualTo(0);
    }

}
