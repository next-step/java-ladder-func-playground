import domain.Ladder;
import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리에서 이동")
    void moveWithLadder() {
        Line line1 = new Line(Arrays.asList(true, false));
        Line line2 = new Line(Arrays.asList(false, true));
        Ladder ladder = new Ladder(Arrays.asList(line1, line2));

        int result = ladder.traverse(0);

        assertThat(result).isEqualTo(2);
    }
}
