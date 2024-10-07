package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리의 상태값을 전달받을 수 있다")
    void getRungsStatusTest() {
        // given
        final List<Boolean> inputRungsStatus = Arrays.asList(true, false, false, false, true, true);
        final Ladder ladder = Ladder.from(inputRungsStatus);
        // when
        final List<Boolean> rungsStatus = ladder.getRungsStatus();
        // then
        assertThat(rungsStatus)
            .containsExactlyElementsOf(inputRungsStatus);
    }

    @Test
    @DisplayName("사다리의 높이를 전달받을 수 있다.")
    void getHeightTest() {
        // given
        final List<Boolean> inputRungsStatus = Arrays.asList(true, false, false, false, true, true);
        final Ladder ladder = Ladder.from(inputRungsStatus);
        // when
        final int height = ladder.getHeight();
        // then
        assertThat(height)
            .isEqualTo(inputRungsStatus.size());
    }

    @Test
    @DisplayName("특정 위치에 사다리가 있는지 없는지 확인할 수 있다.")
    void checkRungExistTest() {
        // given
        final List<Boolean> inputRungsStatus = Arrays.asList(true, false, false, false, true, true);
        final Ladder ladder = Ladder.from(inputRungsStatus);
        // when
        // then
        assertAll(
            () -> assertThat(ladder.checkRungExistAt(0))
                .isEqualTo(inputRungsStatus.get(0)),
            () -> assertThat(ladder.checkRungExistAt(1))
                .isEqualTo(inputRungsStatus.get(1)),
            () -> assertThat(ladder.checkRungExistAt(2))
                .isEqualTo(inputRungsStatus.get(2)),
            () -> assertThat(ladder.checkRungExistAt(3))
                .isEqualTo(inputRungsStatus.get(3)),
            () -> assertThat(ladder.checkRungExistAt(4))
                .isEqualTo(inputRungsStatus.get(4)),
            () -> assertThat(ladder.checkRungExistAt(5))
                .isEqualTo(inputRungsStatus.get(5))
        );
    }


}
