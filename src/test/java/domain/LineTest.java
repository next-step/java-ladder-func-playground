package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("가로 라인은 연속으로 생성되지 않는다.")
    void generateFirst() {
        Line line = Line.generateFirst(new LadderWidth(3), () -> true);

        assertThat(line.isConnectedAt(0)).isTrue();
        assertThat(line.isConnectedAt(1)).isFalse();
    }

    @Test
    @DisplayName("현재 위치에서 연결된 방향으로 이동한다.")
    void move() {
        Line line = new Line(Arrays.asList(true, false));

        assertThat(line.move(new Position(0))).isEqualTo(new Position(1));
        assertThat(line.move(new Position(1))).isEqualTo(new Position(0));
        assertThat(line.move(new Position(2))).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("주입된 불리언 제너레이터의 반환값에 따라 사다리 라인이 검증된다.")
    void generateWithSequentialRandom() {
        BooleanGenerator sequentialGenerator = new BooleanGenerator() {
            private boolean flag = false;

            @Override
            public boolean generate() {
                flag = !flag;
                return flag; // true, false, true, false 순서로 반환
            }
        };

        Line line = Line.generateFirst(new LadderWidth(4), sequentialGenerator);

        assertThat(line.isConnectedAt(0)).isTrue();
        assertThat(line.isConnectedAt(1)).isFalse();
        assertThat(line.isConnectedAt(2)).isTrue();
    }
}