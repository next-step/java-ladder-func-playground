package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    Map<Integer, Integer> ladderIntegerResult = new HashMap<>();
    Map<String, String> ladderStringResult = new HashMap<>();
    List<String> names = new ArrayList<>();
    List<String> targets = new ArrayList<>();

    int width;

    public LadderResult(Ladder ladder, List<String> names, List<String> targets) {
        this.width = ladder.getWidth();
        this.names = names;
        this.targets = targets;
        playLadder(ladder);
        makeStringLadderResult(names, targets);
    }

    public void playLadder(Ladder ladder) {
        for (int i = 0; i < width + 1; i++) {
            movePlayer(ladder, i);
        }
    }

    public void movePlayer(Ladder ladder, int playerStart) {
        int current = playerStart;
        for (Line line : ladder.getLadder()) {
            current = line.move(current);
        }
        ladderIntegerResult.put(playerStart, current);
    }

    public void makeStringLadderResult(List<String> names, List<String> targets) {
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

    public Map<Integer,Integer> getLadderIntegerResult(){
        return ladderIntegerResult;
    }

    public Map<String,String> getLadderStringResult(){
        return ladderStringResult;
    }
}
