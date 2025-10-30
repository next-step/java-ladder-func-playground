package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    // cols = 3  → 각 LinePoints의 길이는 cols - 1 = 2
    private LinePoints linePoints1() {
        return new LinePoints(List.of(true, false));
    }

    private LinePoints linePoints2() {
        return new LinePoints(List.of(false, true));
    }

    @Test
    void 정상_파라미터로_생성되며_게터가_정상동작한다() {
        List<LinePoints> lines = List.of(linePoints1(), linePoints2()); // rows = 2
        int cols = 3;
        int rows = 2;

        Ladder ladder = new Ladder(lines, cols, rows);

        assertEquals(lines, ladder.getLines());
        assertEquals(cols, ladder.getCols());
    }

    @Test
    void cols가_2보다_작으면_예외를_던진다() {
        List<LinePoints> lines = List.of(linePoints1(), linePoints2()); // rows = 2
        int invalidCols = 1; // cols < 2
        int rows = 2;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Ladder(lines, invalidCols, rows)
        );
        assertTrue(ex.getMessage().contains("cols"));
    }

    @Test
    void rows가_1보다_작으면_예외를_던진다() {
        List<LinePoints> lines = List.of(linePoints1(), linePoints2());
        int cols = 3;
        int invalidRows = 0; // rows < 1

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Ladder(lines, cols, invalidRows)
        );
        assertTrue(ex.getMessage().contains("rows"));
    }

    @Test
    void lines의_개수와_rows가_일치하지_않으면_예외를_던진다() {
        // rows = 3인데 lines는 2개 → 불일치
        List<LinePoints> lines = List.of(linePoints1(), linePoints2());
        int cols = 3;
        int rows = 3;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Ladder(lines, cols, rows)
        );
        assertTrue(ex.getMessage().contains("라인 개수와 rows가 일치하지 않습니다"));
    }
}
