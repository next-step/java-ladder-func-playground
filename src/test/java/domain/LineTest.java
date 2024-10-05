package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LineTest {

    @DisplayName("사다리 행 생성 테스트 4줄일 경우 정상 수행")
    @Test
    public void creationTest() {
        Size lineSize = new Size(4);
        Line line = new Line(lineSize);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }
}
