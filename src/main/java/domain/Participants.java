package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<String> names;

    private Participants(List<String> names) {
        validate(names);
        this.names = new ArrayList<>(names);
    }

    public static Participants from(String input) {
        String[] split = input.split(",");
        List<String> names = new ArrayList<>();
        for (String name : split) {
            names.add(name.trim());
        }
        return new Participants(names);
    }

    private void validate(List<String> names) {
        validateNotEmpty(names);
        validateNameLength(names);
    }

    private void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름은 1명 이상이어야 합니다.");
        }
    }

    private void validateNameLength(List<String> names) {
        for (String name : names) {
            validateSingleName(name);
        }
    }

    private void validateSingleName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다: " + name);
        }
    }


    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int indexOf(String name) {
        return names.indexOf(name);
    }
}
