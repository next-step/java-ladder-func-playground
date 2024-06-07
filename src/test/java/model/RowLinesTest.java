package model;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RowLinesTest {

    @Test
    void 열사다리_생성_테스트() {

        // given
        int height = 3;
        int width = 5;

        // when
        RowLines rowLines = RowLines.of(height, width);

        // then
        assertEquals(height, rowLines.getRowLines().size());
        for (Lines lines : rowLines.getRowLines()) {
            assertEquals(width, lines.getLines().size());
        }
=======
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RowLinesTest {

    @Test
    void 행_사다리_테스트() {

        // given
        int width = 5;
        RowLines rowLines = RowLines.of(3, width);
        RowLines rowLines1 = RowLines.of(3, width);

        // when&then
        Assertions.assertEquals(rowLines1, rowLines);
>>>>>>> 6676a85 (Feat:)
    }
}