package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void 왼쪽으로_이동하면_값이_1_감소한다() {
        Position position = new Position(1);
        assertThat(position.moveLeft()).isEqualTo(new Position(0));
    }

    @Test
    void 오른쪽으로_이동하면_값이_1_증가한다() {
        Position position = new Position(1);
        assertThat(position.moveRight()).isEqualTo(new Position(2));
    }
}