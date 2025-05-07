package ladderdomain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리를_통과하면_결과_인덱스를_반환한다() {
        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of());
        Ladder ladder = new Ladder(0, 3, generator);
        int endIndex = ladder.move(1);
        assertEquals(1, endIndex);
    }

    @Test
    void 사다리는_요청한_줄_수만큼_라인을_만든다() {
        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of(true, false, true, false, true));
        Ladder ladder = new Ladder(5, 3, generator);
        assertEquals(5, ladder.getLines().size());
    }
}
