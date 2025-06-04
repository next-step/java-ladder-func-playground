package ladder;

import generator.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomLinkStrategy;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("Line 생성 시, 연속된 Link는 연결되지 않아야 한다")
    void shouldNotHaveConsecutiveLinks() {
        // given
        int columnCount = 6;
        RandomLinkStrategy strategy = new RandomLinkStrategy(new RandomGenerator());
        Line line = new Line(Width.from(columnCount), strategy);

        // when
        List<Link> links = line.getLinks();

        // then
        for (int i = 1; i < links.size(); i++) {
            boolean prevLinked = links.get(i - 1).isLinked();
            boolean currLinked = links.get(i).isLinked();

            assertThat(!(prevLinked && currLinked)).isTrue();
        }
    }
}