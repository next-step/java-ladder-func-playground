import domain.Height;
import domain.Ladder;
import domain.Line;
import domain.LadderGenerator;
import domain.Name;
import domain.Names;
import domain.Results;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DomainValidationTest {

    @Test
    @DisplayName("Name Class Test")
    void nameValidationBoundaryTest() {
        assertDoesNotThrow(() -> new Name("A"));
        assertDoesNotThrow(() -> new Name("12345"));
        assertDoesNotThrow(() -> new Name("가나다라마"));
        assertDoesNotThrow(() -> new Name(" A "));

        assertThrows(IllegalArgumentException.class, () -> new Name(null),
                "null 값은 예외");

        assertThrows(IllegalArgumentException.class, () -> new Name(""),
                "빈 문자열은 예외");

        assertThrows(IllegalArgumentException.class, () -> new Name("   "),
                "공백만 있는 문자열은 예외");

        assertThrows(IllegalArgumentException.class, () -> new Name("123456"),
                "6글자는 예외");

        assertThrows(IllegalArgumentException.class, () -> new Name("가나다라마바"),
                "한글 6글자는 예외");
    }

    @Test
    @DisplayName("Line Class Test")
    void lineMoveMethodBoundaryTest() {
        Line line = new Line(java.util.Arrays.asList(true, false, true));

        assertEquals(1, line.move(0));
        assertEquals(0, line.move(1));
        assertEquals(3, line.move(2));
        assertEquals(2, line.move(3));

        Line disconnectedLine = new Line(java.util.Arrays.asList(false, false));

        assertEquals(0, disconnectedLine.move(0));
        assertEquals(1, disconnectedLine.move(1));
        assertEquals(2, disconnectedLine.move(2));

        Line emptyLine = new Line(java.util.Arrays.asList());

        assertEquals(0, emptyLine.move(0));
    }

    @Test
    @DisplayName("Height, Names 일관성 Test")
    void heightAndNamesConsistencyTest() {
        Names twoNames = Names.from("A,B");
        Names fiveNames = Names.from("A,B,C,D,E");

        Height minHeight = new Height(1);
        Height normalHeight = new Height(5);

        Ladder ladder1 = LadderGenerator.generate(twoNames.size(), minHeight);
        assertNotNull(ladder1);

        Ladder ladder2 = LadderGenerator.generate(fiveNames.size(), normalHeight);
        assertNotNull(ladder2);

        int result1 = ladder1.traverse(0);
        assertTrue(result1 >= 0 && result1 < twoNames.size(),
                "순회 결과는 유효한 인덱스 범위 내에 있어야 함.");

        int result2 = ladder2.traverse(4);
        assertTrue(result2 >= 0 && result2 < fiveNames.size(),
                "순회 결과는 유효한 인덱스 범위 내에 있어야 함.");
    }

    @Test
    @DisplayName("Names와 Results 파싱 및 일관성 테스트")
    void namesAndResultsParsingTest() {
        String input1 = "A,B,C";
        String input2 = " A , B , C ";
        String input3 = "가,나,다";

        Names names1 = Names.from(input1);
        Names names2 = Names.from(input2);
        Names names3 = Names.from(input3);

        Results results1 = Results.from("1등,2등,3등");
        Results results2 = Results.from(" 당첨 , 꽝 , 재도전 ");

        assertEquals(3, names1.size());
        assertEquals(3, names2.size());
        assertEquals(3, names3.size());

        assertEquals("A", names2.getValues().get(0).getValue());
        assertEquals("B", names2.getValues().get(1).getValue());
        assertEquals("C", names2.getValues().get(2).getValue());

        assertEquals("1등", results1.get(0).getValue());
        assertEquals("2등", results1.get(1).getValue());
        assertEquals("3등", results1.get(2).getValue());

        assertEquals("당첨", results2.get(0).getValue());
        assertEquals("꽝", results2.get(1).getValue());
        assertEquals("재도전", results2.get(2).getValue());
    }
}
