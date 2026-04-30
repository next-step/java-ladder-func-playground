package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<Integer, Integer> ladderIntegerResult = new HashMap<>();
    private final Map<String, String> ladderStringResult = new HashMap<>();
    private final List<String> names;
    private final List<String> targets;

    int width;

    public LadderResult(Ladder ladder, List<String> names, List<String> targets) {
        this.width = ladder.getWidth();
        this.names = names;
        this.targets = targets;
        playLadder(ladder);
        makeStringLadderResult(names, targets);
    }

    private void playLadder(Ladder ladder) {
        for (int i = 0; i < width + 1; i++) {
            movePlayer(ladder, i);
        }
    }

    private void movePlayer(Ladder ladder, int playerStart) {
        int current = playerStart;
        for (Line line : ladder.getLadder()) {
            current = line.move(current);
        }
        ladderIntegerResult.put(playerStart, current);
    }

    private void makeStringLadderResult(List<String> names, List<String> targets) {
        for (int i = 0; i < width + 1; i++) {
            ladderStringResult.put(names.get(i), targets.get(ladderIntegerResult.get(i)));
        }
    }

    public String getTargetLadderResult(String name) {
        return ladderStringResult.get(name);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getTargets() {
        return targets;
    }

    public Map<Integer, Integer> getLadderIntegerResult() {
        return ladderIntegerResult;
    }

    public Map<String, String> getLadderStringResult() {
        return ladderStringResult;
    }
}
