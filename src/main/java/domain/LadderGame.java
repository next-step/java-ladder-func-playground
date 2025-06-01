package domain;

import config.GameConfig;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;

    private LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderGame of(GameConfig config) {
        Ladder ladder = Ladder.from(config);
        return new LadderGame(ladder);
    }

    public LadderResult play(Players players, Rewards rewards) {
        Map<Player, Reward> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < ladder.getWidth(); i++) {
            int destination = ladder.move(i);
            Player player = players.get(i);
            Reward reward = rewards.get(destination);
            resultMap.put(player, reward);
        }
        return new LadderResult(resultMap);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
