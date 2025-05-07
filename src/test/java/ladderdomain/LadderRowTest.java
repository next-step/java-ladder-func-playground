package ladderdomain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @Test
    void 연결이_겹치지_않도록_한줄을_생성한다() {
        FixedBooleanGenerator generator = new FixedBooleanGenerator(List.of(false, true, true, false));
        LadderRow row = new LadderRow(5, generator);

        boolean last = false;
        for (Connection c : row.getConnections()) {
            assertFalse(last && c.hasRight());
            last = c.hasRight();
        }
    }

    @Test
    void 하나_이상의_연결이_포함되어야_한다() {
        LadderRow row = new LadderRow(5, () -> true);
        boolean hasAtLeastOne = row.getConnections().stream().anyMatch(Connection::hasRight);
        assertTrue(hasAtLeastOne);
    }
}
