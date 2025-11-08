package model;


import java.util.List;
import java.util.Objects;

public class Results {
    private final List<String> values;

    public Results(List<String> values) {
        this.values = Objects.requireNonNull(values);
    }

    public int size() {
        return values.size();
    }

    public String get(int index) {
        return values.get(index);
    }

    public List<String> getValues() {
        return values;
    }
}
