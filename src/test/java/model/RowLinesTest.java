package model;

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
    }
}