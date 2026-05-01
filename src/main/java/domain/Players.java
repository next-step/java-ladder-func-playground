package domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<PlayerName> names;

    public Players(List<PlayerName> names) {
        this.names = names;
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