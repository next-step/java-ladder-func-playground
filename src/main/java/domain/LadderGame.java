package domain;

import config.GameConfig;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final GameConfig config;
    private final Ladder ladder;

    private LadderGame(GameConfig config, Ladder ladder) {
        this.config = config;
        this.ladder = ladder;
    }

    public static LadderGame of(GameConfig config) {
        Ladder ladder = new LadderGenerator().generate(config);
        return new LadderGame(config, ladder);
    }

    public LadderResult play() {
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < config.getWidth(); i++) {
            int destination = ladder.move(i);
            resultMap.put(i, destination);
        }
        return new LadderResult(resultMap);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
