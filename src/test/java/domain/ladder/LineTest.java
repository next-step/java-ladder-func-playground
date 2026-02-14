package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("현재 위치에 다리가 있으면 오른쪽으로 이동한다")
    @Test
    void moveRightWhenBridgeExists() {
        // given
        Line line = Line.of(List.of(0), 3);
        int position = 0;

        // when
        int result = line.move(position);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("왼쪽 위치에 다리가 있으면 왼쪽으로 이동한다")
    @Test
    void moveLeftWhenLeftBridgeExists() {
        // given
        Line line = Line.of(List.of(0), 3);
        int position = 1;

        // when
        int result = line.move(position);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("다리가 없으면 현재 위치를 유지한다")
    @Test
    void stayWhenNoBridge() {
        // given
        Line line = Line.of(List.of(), 3);
        int position = 1;

        // when
        int result = line.move(position);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("여러 다리가 있는 라인에서 각 위치에 따라 올바르게 이동한다")
    @Test
    void moveWithMultipleBridges() {
        // given
        Line line = Line.of(List.of(0, 2), 4);

        // when & then
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }

}
