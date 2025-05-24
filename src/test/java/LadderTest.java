import domain.Ladder;
import domain.Size;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void createLadder_HeightSize() {
        Size size = new Size(4, 5);
        Ladder ladder = Ladder.create(size);

        assertThat(ladder.getLines()).hasSize(5);
    }
}
