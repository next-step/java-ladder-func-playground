package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.dto.LadderDto;
import domain.dto.LaddersDto;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Errors;

class LaddersTest {

    @Test
    @DisplayName("주어진 LaddersDTO를 활용해 Ladders를 만들 수 있다.")
    void constructorTest() {
        // given
        int height = 3;
        int countOfLadders = 1;
        final LaddersDto laddersDto = new LaddersDto(4);
        final LadderDto ladderDto = LadderDto.of(1);
        laddersDto.addLadderDto(0, ladderDto);
        // when
        final Ladders ladders = Ladders.from(laddersDto, countOfLadders, height);
        // then
        final List<Set<Integer>> allRungsPositionAtLadder = ladders.getAllRungsPositionAtLadder();
        assertThat(allRungsPositionAtLadder.get(0)).contains(1);
    }

    @Test
    @DisplayName("LaddersDto로 넘어오는 사다리들의 가로줄 값 중, 하나의 가로줄도 포함하지 않는 사다리가 있다면 예외가 발생한다.")
    void invalidConstructorTest() {
        // given
        int height = 3;
        int countOfLadders = 2;
        final LaddersDto laddersDto = new LaddersDto(4);
        final LadderDto ladderDto = LadderDto.of(1);
        laddersDto.addLadderDto(0, ladderDto);
        // when
        // then
        assertThatThrownBy(() ->  Ladders.from(laddersDto, countOfLadders, height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.LADDER_DTO_NEED_TO_CREATE);
    }
}
