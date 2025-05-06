package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    private LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderGame create(Ladder ladder, Players players, Prizes prizes) {
        validate(ladder, players, prizes);
        return new LadderGame(ladder, players, prizes);
    }

    public LadderResult play() {
        Map<Integer, Integer> indexResult = ladder.mapStartToEndPositions(players.size());
        return mapIndexToResult(indexResult);
    }

    private LadderResult mapIndexToResult(Map<Integer, Integer> indexResult) {
        Map<String, String> rawLadderResult = new LinkedHashMap<>();
        for (int index = 0; index < players.size(); index++) {
            Integer resultIndex = indexResult.get(index);
            rawLadderResult.put(players.nameAt(index), prizes.labelAt(resultIndex));
        }
        return LadderResult.create(rawLadderResult);
    }

    private static void validate(Ladder ladder, Players players, Prizes prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException("플레이어 수와 상품의 수는 같아야 합니다.");
        }
        if (ladder == null) {
            throw new IllegalArgumentException("사다리를 넘겨주세요.");
        }
    }
}
