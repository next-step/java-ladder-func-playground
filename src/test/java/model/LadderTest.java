package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    private static final int DEFAULT_WIDTH = 5;
    private static final int DEFAULT_HEIGHT = 5;

    @Test
    @DisplayName("너비와 높이를 받아 인스턴스를 생성한다")
    void createByWidthAndHeight() {
        assertThatCode(() -> new Ladder(DEFAULT_WIDTH, DEFAULT_HEIGHT))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("너비가 너무 짧다면 예외가 발생한다")
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1})
    void ifWidthTooShortThenThrowException(int illegalWidth) {
        assertThatThrownBy(() -> new Ladder(illegalWidth, DEFAULT_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("높이가 너무 짧다면 예외가 발생한다")
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void ifHeightTooShortThenThrowException(int illegalHeight) {
        assertThatThrownBy(() -> new Ladder(DEFAULT_WIDTH, illegalHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("생성자에 전달한 높이와 같은 수의 원소를 지닌 Line 컬렉션을 반환한다")
    @ValueSource(ints = {5, 10, 200, 3000})
    void returnLineCollectionWithSameNumberOfElementAsHeight(int height) {
        Ladder ladder = new Ladder(DEFAULT_WIDTH, height);
        List<Line> lines = ladder.getLines();

        assertThat(lines.size()).isEqualTo(height);
    }

}
