package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("랜덤 링크 생성 시, 연속된 Link는 연결되지 않아야 한다")
    void shouldNotHaveConsecutiveLinksAfterRandomlyLink() {
        // given
        int columnCount = 6;
        Line line = new Line(columnCount);

        // when
        line.randomlyLink(new Random());

        // then
        List<Link> links = line.getLinks();

        for (int i = 1; i < links.size(); i++) {
            boolean prevLinked = links.get(i - 1).isLinked();
            boolean currLinked = links.get(i).isLinked();

            // 연속해서 true면 실패
            assertThat(!(prevLinked && currLinked))
                    .isTrue();
        }
    }
}