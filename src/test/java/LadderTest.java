import LadderDomain.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리를_통과하면_결과_인덱스를_반환한다() {
        Ladder ladder = new Ladder(0, 3);
        int endIndex = ladder.move(1);
        assertEquals(1, endIndex);
    }

    @Test
    void 사다리는_요청한_줄_수만큼_라인을_만든다() {
        Ladder ladder = new Ladder(5, 3);
        assertEquals(5, ladder.getLines().size());
    }
}
