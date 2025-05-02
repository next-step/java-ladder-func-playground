package Domain;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<String> values;

    public Result(List<String> values) {
        this.values = List.copyOf(values);
    }

    public String get(int index) {
        return values.get(index);
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(values);
    }
}
