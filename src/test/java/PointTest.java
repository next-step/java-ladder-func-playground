import domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void RowConnetYesReturnTrue() {
        Point point = new Point(true);
        assertThat(point.hasRightConnection()).isTrue();
    }

    @Test
    void RowConnectNoReturnFalse() {
        Point point = new Point(false);
        assertThat(point.hasRightConnection()).isFalse();
    }

    @Test
    void toStringTest() {
        Point connected = new Point(true);
        Point notConnected = new Point(false);

        assertThat(connected.toString()).isEqualTo("|-----");
        assertThat(notConnected.toString()).isEqualTo("|     ");
    }
}
