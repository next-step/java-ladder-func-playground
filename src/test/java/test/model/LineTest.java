package test.model;

import org.junit.jupiter.api.Test;

import model.Line;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @Test
    void 사다리_이동() {
        Line line = new Line(3);
        int newPosition = line.move(1);

        assertTrue(newPosition >= 0 && newPosition < 3);
    }
}
