package domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("왼쪽으로 이동한다.")
    void moveLeft() {
        Position position = new Position(1);
        assertThat(position.moveLeft()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("오른쪽으로 이동한다.")
    void moveRight() {
        Position position = new Position(1);
        assertThat(position.moveRight()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("동일한 값을 가지면 동등한 객체로 취급한다.")
    void equals() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }
}