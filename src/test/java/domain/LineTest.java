package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("사다리 행 생성 테스트 - 중복일 경우 RuntimeException 발생")
    @Test
    public void duplicationCheckTest() {
        List<Point> points = List.of(new Point(true), new Point(false), new Point(true), new Point(true));
        assertThatThrownBy(() -> new Line(points)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("사다리 가로라인은 겹칠 수 없습니다.");
    }
}
