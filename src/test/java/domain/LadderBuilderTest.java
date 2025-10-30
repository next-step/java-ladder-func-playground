package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderBuilderTest {

    private final LadderBuilder builder = new LadderBuilder();

    @Test
    void 한줄_사다리_모두_빈칸() {
        LinePoints linePoints = new LinePoints(List.of(false, false));
        String result = builder.buildSingleLadderCol(linePoints);

        String expected = "|" + "     " + "|" + "     " + "|";
        assertEquals(expected, result);
    }

    @Test
    void 한줄_사다리_혼합() {
        LinePoints linePoints = new LinePoints(List.of(true, false, true));
        String result = builder.buildSingleLadderCol(linePoints);

        String expected = "|" + "-----" + "|" + "     " + "|" + "-----" + "|";
        assertEquals(expected, result);
    }

    @Test
    void 여러줄_사다리를_문자열_목록으로_빌드한다() {
        // cols = (linePoints 길이) + 1 = 3, rows = lines.size() = 2
        LinePoints first  = new LinePoints(List.of(true,  false));
        LinePoints second = new LinePoints(List.of(false, true));
        Ladder ladder = new Ladder(List.of(first, second), /*cols=*/3, /*rows=*/2);

        List<String> lines = builder.buildLadder(ladder);

        assertEquals(2, lines.size());

        String expectedFirst  = "|" + "-----" + "|" + "     " + "|";
        String expectedSecond = "|" + "     " + "|" + "-----" + "|";

        assertEquals(expectedFirst, lines.get(0));
        assertEquals(expectedSecond, lines.get(1));
    }
}
