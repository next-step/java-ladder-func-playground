package service;

import domain.Ladders;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LaddersService {

    private final Random random;

    public LaddersService() {
        this.random = new Random();
    }

    public Ladders getInitialLadders(int countOfLadders) {
        final Ladders newLadders = Ladders.from(countOfLadders);
        final int height = newLadders.getHeight();

        for (int index = 0; index < countOfLadders; index++) {
            final Set<Integer> rungsPositionOfLeftLadder = getRungsPositionOfLeftLadder(newLadders, index);
            final int initialRungPosition = getInitialRungPosition(rungsPositionOfLeftLadder, height);
            newLadders.createRungsAtLadder(index, initialRungPosition);
        }
        return newLadders;
    }

    private int getInitialRungPosition(Set<Integer> rungsPositionOfLeftLadder, int height) {
        List<Integer> possiblePositions = new ArrayList<>();
        for (int nowPosition = 0; nowPosition < height; nowPosition++) {
            checkIfRungCanBeCreatedAtPosition(rungsPositionOfLeftLadder, nowPosition, possiblePositions);
        }
        final int randomIndex = random.nextInt(possiblePositions.size());
        return possiblePositions.get(randomIndex);
    }

    private void checkIfRungCanBeCreatedAtPosition(Set<Integer> rungsPositionOfLeftLadder, int nowPosition,
                                                   List<Integer> possiblePositions) {
        if (rungsPositionOfLeftLadder.contains(nowPosition)) {
            return;
        }
        possiblePositions.add(nowPosition);
    }


    public void setRandomRungsAtLadders(Ladders ladders) {
        final int countOfLadders = ladders.getCountOfLadders();
        final int laddersHeight = ladders.getHeight();

        for (int index = 0; index < countOfLadders; index++) {
            final Set<Integer> rungsPositionOfLeftLadder = getRungsPositionOfLeftLadder(ladders, index);
            final Set<Integer> rungsPositionOfRightLadder = getRungsPositionOfRightLadder(ladders, index);
            final Set<Integer> newRungsPosition = getNewRungsPosition(laddersHeight,
                                                                      rungsPositionOfLeftLadder,
                                                                      rungsPositionOfRightLadder);
            ladders.createRungsAtLadder(index, newRungsPosition);
        }
    }

    private Set<Integer> getNewRungsPosition(int laddersHeight, Set<Integer> rungsPositionOfLeftLadder,
                                             Set<Integer> rungsPositionOfRightLadder) {
        Set<Integer> newRungsPosition = new HashSet<>();
        for (int position = 0; position < laddersHeight; position++) {
            createOrSkipRungAtPosition(position, newRungsPosition, rungsPositionOfLeftLadder,
                                       rungsPositionOfRightLadder);
        }
        return newRungsPosition;
    }

    private void createOrSkipRungAtPosition(int position, Set<Integer> newRungsPosition,
                                            Set<Integer> rungsPositionOfLeftLadder,
                                            Set<Integer> rungsPositionOfRightLadder) {
        if (rungsPositionOfLeftLadder.contains(position) || rungsPositionOfRightLadder.contains(position)) {
            return;
        }
        if (random.nextBoolean()) {
            newRungsPosition.add(position);
        }
    }

    private Set<Integer> getRungsPositionOfLeftLadder(Ladders ladders, int index) {
        if (index == 0) {
            return new HashSet<>();
        }
        return ladders.getRungsPositionAtLadder(index - 1);
    }

    private Set<Integer> getRungsPositionOfRightLadder(Ladders ladders, int index) {
        if (index == ladders.getCountOfLadders() - 1) {
            return new HashSet<>();
        }
        return ladders.getRungsPositionAtLadder(index + 1);
    }
}
