package domain.ladder;

import java.util.List;

public record Ladder(
        List<LadderLine> ladderLines,
        LadderInfo ladderInfo
) {
}
