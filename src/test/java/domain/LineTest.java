package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LineTest {

    @DisplayName("사다리 행 생성 테스트 4줄일 경우 정상 수행")
    @Test
    public void creationTest() {
        Line line = new Line(4);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }

    @DisplayName("사다리 행 연결 중복 테스트")
    @Test
    public void lineDuplicationTest() {
        Line line = new Line(4);
        assertThat(isDuplicate(line)).isEqualTo(false);
    }

    public boolean isDuplicate(Line line) {
        boolean result = false;
        boolean before = false;
        for(Point point : line.getPoints()) {
            result = result || (before && point.isConnected());
            before = point.isConnected();
        }
        return result;
    }
}
