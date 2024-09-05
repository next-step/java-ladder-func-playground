package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.value.Height;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.Errors;

class LadderTest {


    @Test
    @DisplayName("Height 이내의 값을 활용해 가로 줄을 생성할 수 있다.")
    void createRungTest() {
        // given
        final Height height = new Height();
        final Ladder ladder = new Ladder(height);
        // when
        Random random = new Random();
        final int nowPosition = random.nextInt(height.getValue());
        ladder.createRungsAt(nowPosition);
        // then
        final Set<Integer> rungsPosition = ladder.getRungsPosition();
        assertTrue(rungsPosition.contains(nowPosition));
    }

    @ParameterizedTest(name = "{0}은 0 미만이거나 height 이상의 값이어서 가로줄을 생성할 수 없다.")
    @ValueSource(ints = {-2, -1, 100,})
    @DisplayName("0 미만이거나 height 이상의 값으로 가로줄을 만드려하면 예외가 반환된다.")
    void invalidTest1(int nowPosition) {
        final Height height = new Height();
        final Ladder ladder = new Ladder(height);
        // when
        // then
        assertThatThrownBy(() -> ladder.createRungsAt(nowPosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.POSITION_INDEX_OUT_OF_RANGE);
    }

}
