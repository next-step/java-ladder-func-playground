package test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.Line;

class LineTest {

    @Test
    void 사다리_이동_테스트() {
        Line line = new Line(3);
        int newPosition = line.move(1);

        assertTrue(newPosition >= 0 && newPosition < 3);
    }
}
