package domain;

import generator.TestConnectionGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    private static final int ROW_SIZE = 2;
    private static final int LEFT = 0;
    private static final int CENTER = 1;
    private static final int RIGHT = 2;

    @Test
    void TRUE_다음은_FALSE다() {
        Row row = Row.of(ROW_SIZE, new TestConnectionGenerator(List.of(true, true)));

        assertThat(row.getRow()).isEqualTo(List.of(true, false));
    }

    @Test
    void 오른쪽에_선이있으면_오른쪽으로_움직인다() {
        Row row = Row.of(ROW_SIZE, new TestConnectionGenerator(List.of(true, false)));

        int result = row.move(LEFT);

        assertThat(result).isEqualTo(CENTER);
    }

    @Test
    void 왼쪽에_선이있으면_왼쪽으로_움직인다() {
        Row row = Row.of(ROW_SIZE, new TestConnectionGenerator(List.of(false, true)));

        int result = row.move(RIGHT);

        assertThat(result).isEqualTo(CENTER);
    }

    @Test
    void 선이_없으면_움직이지_않는다() {
        Row row = Row.of(ROW_SIZE, new TestConnectionGenerator(List.of(false, false)));

        int result = row.move(CENTER);

        assertThat(result).isEqualTo(CENTER);
    }
}
