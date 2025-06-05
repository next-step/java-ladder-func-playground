package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("다리가 최소 하나씩 생긴다")
    void minimumLadder() throws Exception {
        Field randomField = LinkConnector.class.getDeclaredField("random");
        randomField.setAccessible(true);
        Random rnd = (Random) randomField.get(null);
        rnd.setSeed(728);

        int width = 4;
        int height = 6;
        LinkConnector linkConnector = new LinkConnector();
        LadderBuilder ladderBuilder = new LadderBuilder(linkConnector);
        Ladder ladder = ladderBuilder.build(width, height);
        List<List<Boolean>> lines = ladder.getLines();

        assertEquals(height, lines.size());
    }
}
