package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LadderResultTest {

    @Test
    @DisplayName("사다리 위치 출력")
    void ladderPositionCheck() {
        // 임의로 만든 사다리
        List<List<Boolean>> lines = new ArrayList<>();
        lines.add(Arrays.asList(false, true));
        lines.add(Arrays.asList(false, false));

        Ladder ladder = new Ladder(lines);
        LadderResult ladderResult = new LadderResult();

        ladderResult.printResult(ladder);
    }

}
