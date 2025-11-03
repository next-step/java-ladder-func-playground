package domain;

import java.util.List;

public class Results {
    private final List<ResultName> results;

    public Results(List<ResultName> results) {
        this.results = List.copyOf(results);
    }

    public int size() {
        return results.size();
    }

    public List<ResultName> getResults() {
        return results;
    }
}
