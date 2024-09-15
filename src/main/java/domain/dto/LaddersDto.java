package domain.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LaddersDto {

    private final Map<Integer, LadderDto> ladderDtoByIndex;

    public LaddersDto(int countOfLadders) {
        this.ladderDtoByIndex = new HashMap<>();
        ladderDtoByIndex.put(-1, LadderDto.defaultInstance());
        ladderDtoByIndex.put(countOfLadders, LadderDto.defaultInstance());
    }

    public void addLadderDto(int index, LadderDto ladderDto) {
        ladderDtoByIndex.put(index, ladderDto);
    }

    public void addRungsAt(int index, Set<Integer> rungPositions) {
        final LadderDto ladderDto = ladderDtoByIndex.get(index);
        ladderDto.addRungs(rungPositions);
        ladderDtoByIndex.put(index, ladderDto);
    }

    public Set<Integer> getRungsPositionAtLadderDto(int index) {
        final LadderDto ladderDto = ladderDtoByIndex.get(index);
        return ladderDto.getRungPositions();
    }

    public Map<Integer, LadderDto> getAllLadderDtoByIndex() {
        return ladderDtoByIndex;
    }

}
