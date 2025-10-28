import controller.LadderController;
import model.Ladder;
import model.LadderFactory;
import model.LadderSize;
import model.Line;
import model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LadderTest {
    @Nested
    class LadderException {
        @Test
        @DisplayName("Ladder에 null lines 전달 시 예외 발생")
        void throwExceptionWhenLadderLinesIsNull() {
            assertThrows(
                    NullPointerException.class, () -> {
                        new Ladder(null);
                    }, "null lines는 예외를 발생시켜야 함");
        }

        @Test
        @DisplayName("Line에 null points 예외 발생")
        void throwExceptionWhenLinePointsIsNull() {
            assertThrows(
                    NullPointerException.class, () -> {
                        new Line(null);
                    }, "null points는 예외를 발생시켜야 함");
        }


        @Test
        @DisplayName("LadderFactory에 잘못된 크기 전달 시 예외 발생")
        void InvalidSize() {

            LadderFactory factory = new LadderFactory();

            assertThrows(
                    IllegalArgumentException.class, () -> {
                        LadderSize invalidSize = new LadderSize(1, 0);
                        factory.create(invalidSize, 0);
                    });
        }


        @Test
        @DisplayName("Point의 connected 값이 생성 후 변경되지 않음")
        void pointIsImmutable() {

            Point connectedPoint = new Point(true);
            Point disconnectedPoint = new Point(false);

            boolean connected1 = connectedPoint.isConnected();
            boolean connected2 = connectedPoint.isConnected();
            boolean disconnected1 = disconnectedPoint.isConnected();
            boolean disconnected2 = disconnectedPoint.isConnected();

            assertEquals(connected1, connected2, "Point의 상태는 변하지 않아야 함");
            assertEquals(disconnected1, disconnected2, "Point의 상태는 변하지 않아야 함");
            assertTrue(connected1);
            assertFalse(disconnected1);
        }
    }
}
