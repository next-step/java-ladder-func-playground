package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("생성자 테스트: 연속된 연결 없음")
    void validConnectionsTest() {
        List<Connection> connections = List.of(
                new Connection(false),
                new Connection(true),
                new Connection(false),
                new Connection(false)
        );

        assertDoesNotThrow(() -> new Line(connections));
    }

    @Test
    @DisplayName("생성자 예외 테스트: 연속된 연결 존재")
    void invalidConnectionsTest() {
        List<Connection> connections = List.of(
                new Connection(false),
                new Connection(true),
                new Connection(true),
                new Connection(false)
        );

        assertThrows(IllegalArgumentException.class, () -> new Line(connections));
    }
}
