package ladder.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderControllerTest {

    @Test
    @DisplayName("입력한 이름이 일치하는 지 확인")
    void inputNameTest() {
        String input = " jisoo1 ,jisoo2, jisoo3, jisoo4, jisoo5";
        String[] ArrayNames = input.split(",");
        List<String> names = new ArrayList<>();
        for (String name : ArrayNames) {
            name = name.trim();
            names.add(name);
        }

        List<String> expected = List.of(
                "jisoo1",
                "jisoo2",
                "jisoo3",
                "jisoo4",
                "jisoo5"
        );
        assertEquals(expected, names);
    }

    @Test
    @DisplayName("결과 확인")
    void resultMapping() {
        String inputNames = "a,b";
        String inputResults = "1,2";

        String[] ArrayNames = inputNames.split(",");
        List<String> names = new ArrayList<>();
        for (String name : ArrayNames) {
            name = name.trim();
            names.add(name);
        }

        String[] ArrayResults = inputResults.split(",");
        List<String> results = new ArrayList<>();
        for (String result : ArrayResults) {
            result = result.trim();
            results.add(result);
        }

        assertEquals("a", names.get(0));
        assertEquals("b", names.get(1));
        assertEquals("1", results.get(0));
        assertEquals("2", results.get(1));

        List<String> mappingResult = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            mappingResult.add(names.get(i) + ":" + results.get(i));
        }

        List<String> expected = List.of("a:1", "b:2");
        assertEquals(expected, mappingResult);
    }

}
