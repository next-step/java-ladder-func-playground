package domain;

import config.GameConfig;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final GameConfig config;
    private final Ladder ladder;
    private LadderResult ladderResult;

    private LadderGame(GameConfig config, Ladder ladder) {
        this.config = config;
        this.ladder = ladder;
    }

    public static LadderGame of(GameConfig config) {
        Ladder ladder = new LadderGenerator().generate(config);
        return new LadderGame(config, ladder);
    }

    public void play() {

    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResult getResult() {
        return ladderResult;
    }
}