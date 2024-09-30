package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Errors;

class LaddersTest {

    @Test
    @DisplayName("Ladders를 통해 각 사다리의 가로줄 유무를 모두 받아올 수 있다.")
    void constructorTest() {
        // given
        final List<List<Boolean>> inputRungsStatus = Arrays.asList(
            Arrays.asList(true, false, false, true),
            Arrays.asList(false, false, true, false),
            Arrays.asList(true, true, false, true),
            Arrays.asList(false, false, true, false)
        );
        // when
        List<Ladder> ladderCollection = new ArrayList<>();
        for (List<Boolean> rungsStatus : inputRungsStatus) {
            ladderCollection.add(Ladder.from(rungsStatus));
        }
        final Ladders ladders = Ladders.from(ladderCollection);
        // then
        assertThat(ladders.getRungsStatusAtLadder())
            .containsExactlyElementsOf(inputRungsStatus);
    }

    @Test
    @DisplayName("Ladders 내의 모든 Ladder의 길이가 같지 않다면 예외가 발생한다.")
    void invalidHeightTest() {
        // given
        final Ladder ladder1 = Ladder.from(Arrays.asList(true, false, true));
        final Ladder ladder2 = Ladder.from(Arrays.asList(true, false));
        // when
        List<Ladder> ladderCollection = Arrays.asList(ladder1, ladder2);
        // then
        assertThatThrownBy(() -> Ladders.from(ladderCollection))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.ALL_LADDERS_MUST_HAVE_SAME_HEIGHT);
    }

    @Test
    @DisplayName("Ladders 내의 인접한 사다리는 서로 연결되어선 안된다. (가로줄의 위치가 동일할 수 없다.)")
    void invalidConnectedTest() {
        // given
        final Ladder ladder1 = Ladder.from(Arrays.asList(true, false, false, true));
        final Ladder ladder2 = Ladder.from(Arrays.asList(false, false, false, true));
        // when
        List<Ladder> ladderCollection = Arrays.asList(ladder1, ladder2);
        // then
        assertThatThrownBy(() -> Ladders.from(ladderCollection))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.ADJACENT_LADDERS_CANNOT_HAVE_RUNG_AT_SAME_POSITION);
    }

}
