package ladder;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("라인이 넓이에 따라 정확히 생성돼야한다")
    void generateLineWithWidth() {
        int width = 5;
        Line line = Line.create(width);

        List<Boolean> points = line.getPoints();
        assertThat(points).hasSize(width - 1); // 연결 여부는 width-1 사이즈여야 함
    }

    @Test
    @DisplayName("라인을 연결할 때 연속된 true가 나오지 않는다")
    void validateNoConsecutiveTrueConnections() {

        /*
        * 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우
        * 어느 방향으로 이동할지 결정할 수 없다.
        * */

        int width = 5;
        Line line = Line.create(width);

        List<Boolean> points = line.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            assertThat(points.get(i) && points.get(i + 1))
                .isFalse();
        }
    }
}
