package domain.ladder;

import java.util.List;

public record LadderLine(
        List<Boolean> connections
) {
}
