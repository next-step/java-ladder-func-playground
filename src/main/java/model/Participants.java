package model;

import java.util.List;
import java.util.Objects;

public class Participants {
    private final List<String> names;

    public Participants(List<String> names) {
        validateNames(names);
        this.names = Objects.requireNonNull(names);
    }

    private void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("참여자는 최소 1명 이상이어야 합니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    public int indexOf(String name) {
        return names.indexOf(name);
    }

    public String get(int index) {
        return names.get(index);
    }

    public List<String> getNames() {
        return names;
    }
}
