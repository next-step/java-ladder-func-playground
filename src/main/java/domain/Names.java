package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<String> values;

    public Names(String input) {
        String[] tokens = input.split(",");
        List<String> temp = new ArrayList<>();
        for (String token : tokens) {
            addIfValid(temp, token);
        }
        this.values = List.copyOf(temp);
    }

    private void addIfValid(List<String> temp, String token) {
        String trimmed = token.trim();
        if (!trimmed.isEmpty()) {
            temp.add(trimmed);
        }
    }

    public int size() {
        return values.size();
    }

    public List<String> getValues() {
        return values;
    }
}
