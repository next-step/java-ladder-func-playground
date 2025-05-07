package ladderdomain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {

    @Test
    void 오른쪽으로_연결되어_있으면_true를_반환한다() {
        Connection connection = new Connection(true);
        assertTrue(connection.hasRight());
    }

    @Test
    void 오른쪽으로_연결되어_있지_않으면_false를_반환한다() {
        Connection connection = new Connection(false);
        assertFalse(connection.hasRight());
    }
}
