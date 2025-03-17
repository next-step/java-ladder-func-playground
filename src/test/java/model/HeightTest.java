package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightTest {

    @Test
    void testHeightValidValue() {
        Height height = new Height(5);
        assertThat(height.getValue()).isEqualTo(5);
    }

    @Test
    void testHeightInvalidValue() {
        assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 2 이상이여야 합니다.");
    }

    @Test
    void testHeightMinimumValue() {
        Height height = new Height(2);
        assertThat(height.getValue()).isEqualTo(2);
    }
}
