package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkConnectorTest {

    @Test
    @DisplayName("열 사이의 다리가 겹치면 안된다")
    void notDuplicationLine() throws Exception {
        Field randomField = LinkConnector.class.getDeclaredField("random");
        randomField.setAccessible(true);
        Random random = (Random) randomField.get(null);
        random.setSeed(728);

        int width = 4;
        int height = 6;

        LinkConnector linkConnector = new LinkConnector();
        LadderBuilder ladderBuilder = new LadderBuilder(linkConnector);
        Ladder ladder = ladderBuilder.build(width, height);
        List<List<Boolean>> lines = ladder.getLines();

        for (int i = 0; i < lines.size() - 1; i++) {
            List<Boolean> current = lines.get(i);
            List<Boolean> next = lines.get(i + 1);
            for (int col = 0; col < current.size(); col++) {
                assertFalse(
                        current.get(col) && next.get(col)
                );
            }
        }
    }

}
