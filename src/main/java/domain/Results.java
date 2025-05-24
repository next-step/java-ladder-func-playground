package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {
    private final List<String> results;

    private Results(List<String> results) {
        this.results = new ArrayList<>(results);
    }

    public static Results from(String input) {
        String[] split = input.split(",");
        List<String> results = new ArrayList<>();
        for (String r : split) {
            results.add(r.trim());
        }
        return new Results(results);
    }

    public String get(int index) {
        return results.get(index);
    }

    public int size() {
        return results.size();
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(results);
    }
}
