import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

        @Test
        @DisplayName("연결된 다리가 없는 경우 현재 위치 유지")
        void moveWithNoConnection() {
            Line line = new Line(Arrays.asList(false, false, false));

            assertThat(line.move(0)).isEqualTo(0);
            assertThat(line.move(1)).isEqualTo(1);
            assertThat(line.move(2)).isEqualTo(2);
        }

        @Test
        @DisplayName("오른쪽으로 연결된 다리가 있는 경우 오른쪽으로 이동")
        void moveRightWhenConnected() {
            Line line = new Line(Arrays.asList(true, false, false));

            int newPosition = line.move(0);

            assertThat(newPosition).isEqualTo(1);
        }

        @Test
        @DisplayName("왼쪽에서 연결된 다리가 있는 경우 왼쪽으로 이동")
        void moveLeftWhenConnectedFromLeft() {
            Line line = new Line(Arrays.asList(true, false, false));

            int newPosition = line.move(1);

            assertThat(newPosition).isEqualTo(0);
        }

        @Test
        @DisplayName("양쪽 모두 연결되지 않은 경우 현재 위치 유지")
        void stayWhenNoConnectionOnBothSides() {
            Line line = new Line(Arrays.asList(false, false, false));

            int newPosition = line.move(1);

            assertThat(newPosition).isEqualTo(1);
        }

        @Test
        @DisplayName("첫 번째 위치에서는 왼쪽으로 이동 불가")
        void cannotMoveLeftFromFirstPosition() {
            Line line = new Line(Arrays.asList(false, true));

            int newPosition = line.move(0);

            assertThat(newPosition).isEqualTo(0);
        }

        @Test
        @DisplayName("마지막 위치에서는 오른쪽으로 이동 불가")
        void cannotMoveRightFromLastPosition() {
            Line line = new Line(Arrays.asList(false, false));

            int newPosition = line.move(2);

            assertThat(newPosition).isEqualTo(2);
    }
}
