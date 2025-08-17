package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 오른쪽으로_이동할_수_있으면_오른쪽_인덱스를_반환한다() {
        List<Boolean> connections = Arrays.asList(true, false, false);
        Line line = new Line(connections);

        int result = line.move(0);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 왼쪽으로_이동할_수_있으면_왼쪽_인덱스를_반환한다() {
        List<Boolean> connections = Arrays.asList(false, true, false);
        Line line = new Line(connections);

        int result = line.move(2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 이동이_불가능_하면_현재_인덱스를_반환한다() {
        List<Boolean> connections = Arrays.asList(false, false, false);
        Line line = new Line(connections);

        int result1 = line.move(0);
        int result2 = line.move(1);
        int result3 = line.move(2);

        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(2);
    }

    @Test
    void 오른쪽_범위를_초과하면_인덱스를_그대로_반환한다() {
        List<Boolean> connections = Arrays.asList(true, false);
        Line line = new Line(connections);

        int result = line.move(connections.size());

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 왼쪽_범위를_초과하면_인덱스를_그대로_반환한다() {
        List<Boolean> connections = Arrays.asList(false, true);
        Line line = new Line(connections);

        int result = line.move(0);

        assertThat(result).isEqualTo(0);
    }
}
