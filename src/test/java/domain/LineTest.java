package domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void 왼쪽이_연결되어_있으면_왼쪽으로_이동한다() {
        Line line = new Line(List.of(true, false));
        Position current = new Position(1);
        assertThat(line.move(current)).isEqualTo(new Position(0));
    }

    @Test
    void 오른쪽이_연결되어_있으면_오른쪽으로_이동한다() {
        Line line = new Line(List.of(true, false));
        Position current = new Position(0);
        assertThat(line.move(current)).isEqualTo(new Position(1));
    }

    @Test
    void 양쪽_모두_연결되어_있지_않으면_그대로_머문다() {
        Line line = new Line(List.of(false, false));
        Position current = new Position(1);
        assertThat(line.move(current)).isEqualTo(new Position(1));
    }
}
