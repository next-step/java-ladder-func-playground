package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.Errors;

public class Ladders {

    private final List<Ladder> ladders;

    private Ladders(List<Ladder> ladders) {
        this.ladders = new ArrayList<>(ladders);
    }

    public static Ladders from(List<Ladder> ladderCollection) {
        validate(ladderCollection);
        return new Ladders(ladderCollection);
    }

    private static void validate(List<Ladder> ladders) {
        validateLaddersHeight(ladders);
        validateCheckConnectedRung(ladders);
    }

    private static void validateLaddersHeight(List<Ladder> ladders) {
        boolean allSameHeight = ladders.stream()
            .map(Ladder::getHeight)
            .distinct()
            .count() == 1;
        if (!allSameHeight) {
            throw new IllegalArgumentException(Errors.ALL_LADDERS_MUST_HAVE_SAME_HEIGHT);
        }
    }

    private static void validateCheckConnectedRung(List<Ladder> ladders) {
        if (isLaddersHasConnectedLadder(ladders)) {
            throw new IllegalArgumentException(Errors.ADJACENT_LADDERS_CANNOT_HAVE_RUNG_AT_SAME_POSITION);
        }
    }

    private static boolean isLaddersHasConnectedLadder(List<Ladder> ladders) {
        if (ladders.size() < 2) {
            return false;
        }
        return IntStream.range(0, ladders.size() - 1)
            .anyMatch(index -> isConnected(ladders.get(index), ladders.get(index + 1)));
    }

    private static boolean isConnected(Ladder currentLadder, Ladder nextLadder) {
        final int height = currentLadder.getHeight();
        return IntStream.range(0, height)
            .anyMatch(position -> isConnected(currentLadder, nextLadder, position));
    }

    private static boolean isConnected(Ladder currentLadder, Ladder nextLadder, int position) {
        return currentLadder.checkRungExistAt(position) && nextLadder.checkRungExistAt(position);
    }

    public List<List<Boolean>> getRungsStatusAtLadder() {
        return ladders.stream()
            .map(Ladder::getRungsStatus)
            .collect(Collectors.toList());
    }

}
