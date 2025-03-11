package dto;

import domain.Ladder;
import domain.Line;
import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {
    private final List<List<Boolean>> ladderData;

    public LadderDto(List<List<Boolean>> ladderData) {
        this.ladderData = ladderData;
    }

    public static LadderDto from(Ladder ladder) {
        return new LadderDto(
                ladder.getLines().getLines().stream()
                        .map(Line::getPoints)
                        .collect(Collectors.toList())
        );
    }

    public List<List<Boolean>> getLadderData() {
        return ladderData;
    }
}
