package domain;

import domain.dto.LaddersDto;
import domain.dto.LadderDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import util.Errors;

public class Ladders {

    private final List<Ladder> ladders;

    private Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public static Ladders from(LaddersDto laddersDto, int countOfLadders, int height) {
        List<Ladder> ladders = new ArrayList<>();

        final Map<Integer, LadderDto> ladderDtoByIndex = laddersDto.getAllLadderDtoByIndex();
        for (int index = 0; index < countOfLadders; index++) {
            final LadderDto ladderDto = getLadderDto(ladderDtoByIndex, index);
            final Ladder ladder = Ladder.from(ladderDto, height);
            ladders.add(ladder);
        }
        return new Ladders(ladders);
    }

    private static LadderDto getLadderDto(Map<Integer, LadderDto> ladderDtoByIndex, int index) {
        if (!ladderDtoByIndex.containsKey(index)) {
            throw new IllegalArgumentException(Errors.LADDER_DTO_NEED_TO_CREATE);
        }
        return ladderDtoByIndex.get(index);
    }

    public List<Set<Integer>> getAllRungsPositionAtLadder() {
        return ladders.stream()
            .map(Ladder::getRungPositions)
            .collect(Collectors.toList());
    }

}
