package domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<PlayerName> names;

    public Players(List<PlayerName> names) {
        this.names = names;
    }

    public void validateMatch(Rewards rewards) {
        if (this.names.size() != rewards.size()) {
            throw new IllegalArgumentException("사람 수와 결과 수가 일치하지 않습니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public PlayerName getName(int index) {
        return names.get(index);
    }

    public List<PlayerName> getNames() {
        return Collections.unmodifiableList(names);
    }
}
