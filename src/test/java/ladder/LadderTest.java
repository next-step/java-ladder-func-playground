package ladder;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.model.Ladder;
import ladder.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("입력받은 넓이와 높이대로 사다리가 생성되어야한다.")
    void generateLadder() {
        // given
        int width = 4;  // 넓이
        int height = 5; // 높이

        // when
        Ladder ladder = Ladder.create(width, height);

        // then
        assertThat(ladder.getLines()).hasSize(height); // 높이에 맞게 생성되었는지 확인

        // 각 Line의 너비 확인 (width - 1개의 Boolean 리스트여야 함)
        ladder.getLines().forEach(line ->
            assertThat(line.getPoints()).hasSize(width - 1)
        );

    }

    @Test
    @DisplayName("사다리 게임의 결과를 확인한다.")
    void getLadderResult() {
        // given
        Ladder ladder = Ladder.create(4, 5);

        // when
        List<Point> results = ladder.result();

        // then
        assertThat(results).hasSize(4); // 참가자 수 = 결과가 나와야 한다.

        // 각 결과의 출발점과 도착점 검사
        for (int i = 0; i < results.size(); i++) {
            assertThat(results.get(i).getStart()).isEqualTo(i); // 출발점이 i와 같음
            assertThat(results.get(i).getEnd()).isBetween(0, 3); // 도착점은 [0, 3](넓이 값) 사이
        }
    }
}
