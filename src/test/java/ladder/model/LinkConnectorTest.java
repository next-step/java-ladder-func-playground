package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkConnectorTest {

    @BeforeEach
    void seedRandom() throws Exception {
        Field field = LinkConnector.class.getDeclaredField("random");
        field.setAccessible(true);
        Random random = (Random) field.get(null);
        random.setSeed(728);
    }

    @Test
    @DisplayName("사다리에 연속된 다리가 생기지 말아야 한다")
    void notConnectorBridge() {
        LinkConnector connector = new LinkConnector();
        int width = 10;
        // 가독성을 위해 i 대신 attempt 사용
        for (int attempt = 0; attempt < 20; attempt++) {
            List<Boolean> links = connector.generate(width);
            for (int j = 0; j < links.size() - 1; j++) {
                assertFalse(links.get(j) && links.get(j + 1));
                // 다리가 연속으로 생기지 않아 통과
            }
        }
    }

}
