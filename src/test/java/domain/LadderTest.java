package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.dto.LadderDto;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Errors;

class LadderTest {

    @Test
    @DisplayName("LadderDTO로 생성할 수 있다.")
    void constructorTest() {
        // given
        int height = 3;
        int initialRungPosition = 1;
        final LadderDto ladderDto = LadderDto.of(initialRungPosition);
        // when
        final Ladder ladder = Ladder.from(ladderDto, height);
        // then
        final Set<Integer> rungPositions = ladder.getRungPositions();
        assertThat(rungPositions).contains(initialRungPosition);
    }

    @ParameterizedTest
    @CsvSource({
        "3, -1",
        "3, 4"
    })
    @DisplayName("가로줄의 위치가 0 미만이거나 사다리의 높이(=최대 위치)를 넘어설 수 없다.")
    void invalidConstructorTest(int height, int initialRungPosition) {
        // given
        final LadderDto ladderDto = LadderDto.of(initialRungPosition);
        // when
        // then
        assertThatThrownBy(() ->  Ladder.from(ladderDto, height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.POSITION_INDEX_OUT_OF_RANGE);
    }

}
