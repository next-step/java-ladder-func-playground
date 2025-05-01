package Domain;

import java.util.Collections;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = List.copyOf(results);
    }

    public Result get(int index) {
        return results.get(index);
    }

    public List<Result> getAll() {
        return Collections.unmodifiableList(results);
    }
}
