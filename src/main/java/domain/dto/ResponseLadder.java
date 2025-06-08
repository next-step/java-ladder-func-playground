package domain.dto;

import domain.ladder.Ladder;
import java.util.List;

public record ResponseLadder(
        List<ResponseLine> lines
) {

    public static ResponseLadder from(final Ladder ladder) {
        List<ResponseLine> lines = ladder.getLines().stream()
                .map(ResponseLine::from)
                .toList();
        return new ResponseLadder(lines);
    }
}
