package Model;

import java.util.Collections;
import java.util.List;

public class Rewards extends SplitMethod {
    List<String> rewards;

    public Rewards(String rewards) {
        this.rewards = split(rewards);
    }

    public String getRewardskey(int index) {
        return rewards.get(index);
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
