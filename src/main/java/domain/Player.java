package domain;

import java.util.Collections;
import java.util.List;

public class Player {
    private final PlayerName name;
    private final Reward reward;

    public Player(PlayerName name, Reward reward) {
        this.name = name;
        this.reward = reward;
    }

    public boolean hasName(String targetName) {
        return this.name.getValue().equals(targetName);
    }

    public PlayerName getName() {
        return name;
    }

    public Reward getReward() {
        return reward;
    }
}