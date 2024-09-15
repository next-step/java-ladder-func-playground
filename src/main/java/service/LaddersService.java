package service;

import domain.AvailablePositionsFilter;
import domain.Ladders;
import domain.RungsBuilder;
import domain.dto.LadderDto;
import domain.dto.LaddersDto;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LaddersService {

    private final RungsBuilder rungsBuilder;

    public LaddersService(RungsBuilder rungsBuilder) {
        this.rungsBuilder = rungsBuilder;
    }

    public int getHeight() {
        Random random = new Random();
        return random.nextInt(2, 6);
    }

    public Ladders createLadders(int countOfLadders, int maxPosition) {
        final LaddersDto laddersDto = createInitialLaddersDto(countOfLadders, maxPosition);
        buildRungsAtLadders(laddersDto, countOfLadders, maxPosition);

        return Ladders.from(laddersDto, countOfLadders, maxPosition);
    }

    private LaddersDto createInitialLaddersDto(int countOfLadders, int maxPosition) {
        final LaddersDto ladders = new LaddersDto(countOfLadders);

        for (int index = 0; index < countOfLadders; index++) {
            final Set<Integer> rungsPositionOfLeftLadder = getRungsPositionOfLeftLadder(ladders, index);
            final int initialRungPosition = getInitialRungPosition(rungsPositionOfLeftLadder, maxPosition);

            final LadderDto ladderDto = LadderDto.of(initialRungPosition);
            ladders.addLadderDto(index, ladderDto);
        }
        return ladders;
    }

    private int getInitialRungPosition(Set<Integer> rungsPositionOfLeftLadder, int maxPosition) {
        if (this.rungsBuilder instanceof AvailablePositionsFilter) {
            ((AvailablePositionsFilter) this.rungsBuilder)
                .setAvailablePositionsExcluding(rungsPositionOfLeftLadder, maxPosition);
        }

        return rungsBuilder.getPositionOfRung();
    }

    private void buildRungsAtLadders(LaddersDto ladders, int countOfLadders, int maxPosition) {
        for (int index = 0; index < countOfLadders; index++) {
            final Set<Integer> excludedPositionsOfRung = getExcludedPositionsOfRung(ladders, index);
            final Set<Integer> positionsOfRungs = getRungPositions(excludedPositionsOfRung, maxPosition);

            ladders.addRungsAt(index, positionsOfRungs);
        }
    }

    private Set<Integer> getRungPositions(Set<Integer> excludedPositionsOfRung, int maxPosition) {
        if (this.rungsBuilder instanceof AvailablePositionsFilter) {
            ((AvailablePositionsFilter) this.rungsBuilder)
                .setAvailablePositionsExcluding(excludedPositionsOfRung, maxPosition);
        }
        return rungsBuilder.getPositionsOfRungs();
    }

    private Set<Integer> getExcludedPositionsOfRung(LaddersDto ladders, int index) {
        return Stream.of(
                getRungsPositionOfLeftLadder(ladders, index),
                getRungsPositionOfRightLadder(ladders, index))
            .flatMap(Set::stream)
            .collect(Collectors.toSet());
    }

    private Set<Integer> getRungsPositionOfLeftLadder(LaddersDto ladders, int index) {
        return ladders.getRungsPositionAtLadderDto(index - 1);
    }

    private Set<Integer> getRungsPositionOfRightLadder(LaddersDto ladders, int index) {
        return ladders.getRungsPositionAtLadderDto(index + 1);
    }

}
