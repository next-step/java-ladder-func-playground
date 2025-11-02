package Model;

import java.util.Collections;
import java.util.List;

public class Rewards{
    List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public String getRewardskey(int index) {
        return rewards.get(index);
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
