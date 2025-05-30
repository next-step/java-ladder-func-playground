import domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class NamesTest {
    @Test
    @DisplayName("쉼표로 구분된 이름들 파싱")
    void parseNamesFromCommaSeparatedString() {
        String input = "홍길동,김철수,이영희";

        Names names = Names.from(input);

        assertEquals(3, names.size());
    }

    @Test
    @DisplayName("names 크기 반환")
    void getSize() {
        Names names = Names.from("A,B,C");

        int size = names.size();

        assertEquals(3, size);
    }
}
