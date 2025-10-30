package domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultCalculatorTest {

    private final LadderResultCalculator calculator = new LadderResultCalculator();

    @Nested
    class ChangeRowLocationTest {

        @Test
        void 왼쪽으로_이동한다() {
            // cols = 3 → linePoints 길이 = 2
            LinePoints linePoints = new LinePoints(List.of(false, true));

            int result = calculator.changeRowLocation(2, linePoints);
            assertEquals(1, result);
        }

        @Test
        void 오른쪽으로_이동한다() {
            LinePoints linePoints = new LinePoints(List.of(true, false));

            int result = calculator.changeRowLocation(0, linePoints);
            assertEquals(1, result);
        }

        @Test
        void 이동하지_않는다() {
            LinePoints linePoints = new LinePoints(List.of(false, false));

            int result = calculator.changeRowLocation(1, linePoints);
            assertEquals(1, result);
        }
    }

    @Nested
    class GetFinalColumnIndexTest {

        @Test
        void 모든_라인을_통과한_후_최종_열_인덱스를_계산한다() {
            // cols = 3 → 각 LinePoints 길이 = 2, rows = 2 → lines.size()와 일치
            LinePoints firstLine  = new LinePoints(List.of(true,  false));
            LinePoints secondLine = new LinePoints(List.of(false, true));
            Ladder ladder = new Ladder(List.of(firstLine, secondLine), /*cols=*/3, /*rows=*/2);

            assertEquals(2, calculator.getFinalColumnIndex(0, ladder));
            assertEquals(0, calculator.getFinalColumnIndex(1, ladder));
            assertEquals(1, calculator.getFinalColumnIndex(2, ladder));
        }
    }

    @Nested
    class CalculateResultsTest {

        @Test
        void 플레이어와_상금을_올바르게_매핑한다() {
            // cols = 3, rows = 2
            LinePoints firstLine  = new LinePoints(List.of(true,  false));
            LinePoints secondLine = new LinePoints(List.of(false, true));
            Ladder ladder = new Ladder(List.of(firstLine, secondLine), 3, 2);

            List<String> players = List.of("A", "B", "C"); // size = cols
            List<String> prizes  = List.of("X", "Y", "Z"); // size = cols

            Map<String, String> expected = new LinkedHashMap<>();
            expected.put("A", "Z"); // 0 → 2
            expected.put("B", "X"); // 1 → 0
            expected.put("C", "Y"); // 2 → 1

            Map<String, String> actual = calculator.calculateResults(ladder, players, prizes);

            assertEquals(expected, actual);
        }
    }
}
