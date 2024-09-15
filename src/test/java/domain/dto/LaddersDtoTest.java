package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersDtoTest {

    private LaddersDto laddersDto;
    private int countOfLadders;

    @BeforeEach
    void setUp() {
        countOfLadders = 4;
        laddersDto = new LaddersDto(countOfLadders);
    }

    // (1) 처음 생성했을 때 default 값 받을 수 있는지
    @Test
    @DisplayName("사다리의 개수가 주어지면, 사다리 제일 왼쪽(index=-1), 사다리 제일 오른쪽에 기본 LadderDto가 추가된다.")
    void constructorTest() {
        // given
        // when
        // then
        final Set<Integer> preLadderPosition = laddersDto.getRungsPositionAtLadderDto(-1);
        final Set<Integer> sufLadderPosition = laddersDto.getRungsPositionAtLadderDto(countOfLadders);
        assertAll(
            () -> assertThat(preLadderPosition.size()).isEqualTo(0),
            () -> assertThat(sufLadderPosition.size()).isEqualTo(0)
        );
    }

    // (2) ladderDto 추가 되는지
    @Test
    @DisplayName("주어진 Index에 LadderDto를 추가할 수 있다.")
    void addLadderDtoTest() {
        // given
        int initialPosition = 1;
        Set<Integer> addPosition = new HashSet<>();
        addPosition.add(2);
        addPosition.add(3);
        addPosition.add(4);
        final LadderDto ladderDto = LadderDto.of(initialPosition);
        ladderDto.addRungs(addPosition);
        // when
        laddersDto.addLadderDto(2, ladderDto);
        // then
        final Set<Integer> rungPositions = laddersDto.getRungsPositionAtLadderDto(2);
        assertAll(
            () -> assertThat(rungPositions.size()).isEqualTo(4),
            () -> assertThat(rungPositions).containsAll(addPosition),
            () -> assertThat(rungPositions).contains(initialPosition)
        );
    }

    // (3) rung 추가하는거
    @Test
    @DisplayName("주어진 index에 있는 LadderDTO에, 주어진 Set<Integer>에 해당하는 가로줄 위치를 추가할 수 있다.")
    void addRungsAtTest() {
        // given
        int initialPosition = 1;
        final LadderDto ladderDto = LadderDto.of(initialPosition);
        laddersDto.addLadderDto(0, ladderDto);
        // when
        Set<Integer> addPosition = new HashSet<>();
        addPosition.add(2);
        addPosition.add(3);
        addPosition.add(4);

        laddersDto.addRungsAt(0, addPosition);
        // then
        final Set<Integer> rungPositions = laddersDto.getRungsPositionAtLadderDto(0);
        assertAll(
            () -> assertThat(rungPositions.size()).isEqualTo(4),
            () -> assertThat(rungPositions).containsAll(addPosition),
            () -> assertThat(rungPositions).contains(initialPosition)
        );
    }
}
