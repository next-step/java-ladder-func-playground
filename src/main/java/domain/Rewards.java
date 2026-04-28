package domain;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<Reward> items;

    public Rewards(List<Reward> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public Reward getReward(int index) {
        return items.get(index);
    }

    public List<Reward> getItems() {
        return Collections.unmodifiableList(items);
    }
}
