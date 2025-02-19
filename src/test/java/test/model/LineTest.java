package test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.Line;

class LineTest {

    @Test
    void 사다리_이동_테스트() {
        Line line = new Line(3);
        int newPosition = line.move(1);

        // 이동 후 위치가 유효한 범위 내인지 확인
        assertTrue(newPosition >= 0 && newPosition < 3);
    }
}
