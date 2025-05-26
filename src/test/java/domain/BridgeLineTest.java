package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeLineTest {

    @ParameterizedTest(name = "index {0}는 연결 상태가 {1}이다")
    @MethodSource("connectionCases")
    @DisplayName("isConnectedAt은 연결 여부를 반환한다")
    void isConnectedAt_returnsExpected(int index, boolean expected) {
        BridgeLine line = new BridgeLine(List.of(false, true, false));
        assertThat(line.isConnectedAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("width는 연결 수를 반환한다")
    void width_returnsConnectionSize() {
        BridgeLine line = new BridgeLine(List.of(true, false, true));
        assertThat(line.width()).isEqualTo(3);
    }

    @ParameterizedTest(name = "위치 {0}에서 다음 위치는 {1}이다")
    @MethodSource("nextPositionCases")
    @DisplayName("nextPositionFrom은 연결에 따라 위치를 이동한다")
    void nextPositionFrom_returnsExpected(int current, int expected) {
        BridgeLine line = new BridgeLine(List.of(true, false, true));
        assertThat(line.nextPositionFrom(current)).isEqualTo(expected);
    }

    private static Stream<Arguments> connectionCases() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(-1, false),
                Arguments.of(3, false)
        );
    }

    private static Stream<Arguments> nextPositionCases() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 3),
                Arguments.of(3, 2)
        );
    }
}
