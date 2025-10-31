package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<Name> values;

    public Names(String input) {
        List<String> tokens = List.of(input.split(","));
        List<Name> temp = new ArrayList<>();
        for (String token : tokens) {
            addIfValid(temp, token);
        }
        this.values = List.copyOf(temp);
    }

    public Names(List<Name> names) {
        this.values = List.copyOf(names);
    }

    private void addIfValid(List<Name> temp, String token) {
        String trimmed = token.trim();
        temp.add(new Name(trimmed));
    }

    public int size() {
        return values.size();
    }

    public List<Name> getValues() {
        return values;
    }
}
