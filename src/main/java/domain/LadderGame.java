package domain;

import config.GameConfig;

public class LadderGame {
    private final GameConfig gameConfig;
    private Ladder ladder;

    public LadderGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void run() {
        LadderGenerator generator = new LadderGenerator();
        ladder = generator.generate(gameConfig);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
