package domain;

import domain.value.Height;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.Errors;

public class Ladders {

    private final List<Ladder> ladders;
    private final Height height;

    private Ladders(List<Ladder> ladders, Height height) {
        this.ladders = ladders;
        this.height = height;
    }

    public static Ladders from(int countOfLadders) {
        final Height height = new Height();
        final List<Ladder> initLadders = IntStream.range(0, countOfLadders)
            .mapToObj(i -> new Ladder(height))
            .collect(Collectors.toList());
        return new Ladders(initLadders, height);
    }

    public int getCountOfLadders() {
        return ladders.size();
    }

    public int getHeight() {
        return height.getValue();
    }

    public Set<Integer> getRungsPositionAtLadder(int index) {
        if (index < 0 || index >= ladders.size()) {
            throw new IllegalArgumentException(Errors.LADDER_INDEX_OUT_OF_RANGE); // 예외처리
        }
        return ladders.get(index).getRungsPosition();
    }

    public List<Set<Integer>> getAllRungsPositionAtLadder() {
        return ladders.stream()
            .map(Ladder::getRungsPosition)
            .collect(Collectors.toList());
    }

    public void createRungsAtLadder(int index, Set<Integer> newRungsPositionAtLadder) {
        final Ladder ladder = ladders.get(index);
        ladder.createRungsAt(newRungsPositionAtLadder);
    }

    public void createRungsAtLadder(int index, int newRungsPositionAtLadder) {
        final Ladder ladder = ladders.get(index);
        ladder.createRungsAt(newRungsPositionAtLadder);
    }

}
