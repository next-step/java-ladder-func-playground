package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SizeTest {

    @Test
    void normalSize() {
        final int width = 10;
        final int height = 10;

        assertDoesNotThrow(() -> new Size(width, height));
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void unexpectedArgument(int width, int height) {
        assertThatThrownBy(() -> new Size(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 입력 불가");
    }

    static Stream<Arguments> negativeValues() {
        return Stream.of(
                Arguments.of(-1, 10),
                Arguments.of(10, -1),
                Arguments.of(-1, -1)
        );
    }
}
