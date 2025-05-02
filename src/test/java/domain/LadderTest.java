package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static domain.Line.*;

class LadderTest {

    @Test
    @DisplayName("사다리를_적절히_생성한다")
    void 사다리를_적절히_생성한다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(
                CONNECTED, NOT_CONNECTED, CONNECTED,                //       |-----|     |-----|
                NOT_CONNECTED, CONNECTED, NOT_CONNECTED,            //       |     |-----|     |
                CONNECTED, NOT_CONNECTED, CONNECTED,                //       |-----|     |-----|
                CONNECTED, NOT_CONNECTED, NOT_CONNECTED             //       |-----|     |     |
        );
        Players players = Players.from(List.of("A", "B", "C", "D"));

        //when
        Ladder ladder = Ladder.create(fixedBooleanGenerator, LadderHeight.create(4), players);
        List<List<Boolean>> actualLines = ladder.getLines().stream()
                .map(Line::getPoints)
                .collect(Collectors.toList());
        List<List<Boolean>> expectedLines = List.of(
                List.of(CONNECTED, NOT_CONNECTED, CONNECTED),
                List.of(NOT_CONNECTED, CONNECTED, NOT_CONNECTED),
                List.of(CONNECTED, NOT_CONNECTED, CONNECTED),
                List.of(CONNECTED, NOT_CONNECTED, NOT_CONNECTED)
        );

        // then
        Assertions.assertThat(actualLines).isEqualTo(expectedLines);
    }

    @Test
    @DisplayName("시작_위치와_끝_위치를_적절히_매칭시킨다")
    void 시작_위치와_끝_위치를_적절히_매칭시킨다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(
                CONNECTED, NOT_CONNECTED, CONNECTED,                //       |-----|     |-----|
                NOT_CONNECTED, CONNECTED, NOT_CONNECTED,            //       |     |-----|     |
                CONNECTED, NOT_CONNECTED, CONNECTED,                //       |-----|     |-----|
                CONNECTED, NOT_CONNECTED, NOT_CONNECTED             //       |-----|     |     |
        );
        Players players = Players.from(List.of("A", "B", "C", "D"));
        Ladder ladder = Ladder.create(fixedBooleanGenerator, LadderHeight.create(4), players);

        //when
        Map<Integer, Integer> startAndEndMap = ladder.mapStartToEndPositions(players.size());

        //then
        Assertions.assertThat(startAndEndMap.get(0)).isEqualTo(3);
        Assertions.assertThat(startAndEndMap.get(1)).isEqualTo(0);
        Assertions.assertThat(startAndEndMap.get(2)).isEqualTo(2);
        Assertions.assertThat(startAndEndMap.get(3)).isEqualTo(1);
    }
}
