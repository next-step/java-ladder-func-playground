package model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LinesTest {

    @Test
    void 너비_테스트() {

        // given
        Lines lines = Lines.from(3);

        // when&then
        assertEquals(3, lines.getLines().size());
    }
    @Test
    void 높이_너비_테스트() {

        // given
        RowLines rowLines = RowLines.of(5, 3);

        // when&then
        assertEquals(5, rowLines.getRowLines().size());
    }
}