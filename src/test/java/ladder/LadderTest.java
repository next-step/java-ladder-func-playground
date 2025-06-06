package ladder;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.model.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void generateLadder() {
        Ladder ladder = Ladder.create(4, 5);
        List<Integer> results = ladder.result();

        assertThat(results).hasSize(4);
        assertThat(results)
            .allMatch(position -> position >= 0 && position < 4);
    }
}
