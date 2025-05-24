import domain.Ladder;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void createLadder_HeightSize() {
        int height = 4;
        int width = 4;
        Ladder ladder = new Ladder(height, width, new Random());

        assertThat(ladder.lines()).hasSize(height);
    }
}
