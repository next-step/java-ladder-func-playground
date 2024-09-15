package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderDtoTest {

    // (1) 초기값 세팅 테스트
    @Test
    @DisplayName("초기 가로줄의 위치 하나가 주어지면, 이를 포함한 LadderDto가 생성된다.")
    void makeLadderDtoTest() {
        // given
        int initialRungPosition = 1;
        // when
        final LadderDto ladderDto = LadderDto.of(initialRungPosition);
        // then
        final Set<Integer> rungPositions = ladderDto.getRungPositions();
        assertAll(
            () -> assertThat(rungPositions.size()).isEqualTo(1),
            () -> assertThat(rungPositions).contains(initialRungPosition)
        );
    }

    @Test
    @DisplayName("가로줄의 위치를 하나도 가지고 있지 않은 기본 LadderDTO 객체를 생성할 수 있다.")
    void makeDefaultInstanceTest() {
        // given
        // when
        final LadderDto ladderDto = LadderDto.defaultInstance();
        // then
        final Set<Integer> rungPositions = ladderDto.getRungPositions();
        assertThat(rungPositions.size()).isEqualTo(0);
    }

    // (2) 여러개 추가 테스트
    @Test
    @DisplayName("초기 값을 생성한 이후, ladderDto에 Set<Integer>를 활용하여 가로줄의 위치를 추가할 수 있다.")
    void addRungsTest() {
        // given
        int initialRungPosition = 1;
        final Set<Integer> addRungPositions = new HashSet<>();
        addRungPositions.add(2);
        addRungPositions.add(3);
        addRungPositions.add(4);
        // when
        final LadderDto ladderDto = LadderDto.of(initialRungPosition);
        ladderDto.addRungs(addRungPositions);
        // then
        final Set<Integer> rungPositions = ladderDto.getRungPositions();
        assertAll(
            () -> assertThat(rungPositions.size()).isEqualTo(4),
            () -> assertThat(rungPositions).containsAll(addRungPositions),
            () -> assertThat(rungPositions).contains(initialRungPosition)
        );
    }

}
