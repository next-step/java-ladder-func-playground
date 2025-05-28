package domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validate(rewards);
        this.rewards = rewards;
    }

    private void validate(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("보상 목록은 비어 있을 수 없습니다.");
        }
    }

    public List<Reward> getRewards() {
        return List.copyOf(rewards);
    }

    public int size() {
        return rewards.size();
    }

    public Reward get(int index) {
        return rewards.get(index);
    }
}
