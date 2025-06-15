package domain.runningResult;

import java.util.Collections;
import java.util.List;

public class Results {

    private final List<Result> values;

    private Results(final List<Result> values) {
        this.values = values;
    }

    public static Results from(final List<String> results) {
        return new Results(
                results.stream()
                        .map(Result::new)
                        .toList()
        );
    }

    public String value(final int index) {
        return values.get(index).value();
    }

    public List<Result> asList() {
        return Collections.unmodifiableList(values);
    }
}
