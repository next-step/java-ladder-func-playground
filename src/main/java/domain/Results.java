package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> values;

    private Results(List<Result> values) {
        this.values = values;
    }

    public static Results from(String input) {
        List<Result> results = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Result::new)
                .collect(Collectors.toList());
        return new Results(results);
    }

    public Result get(int index) {
        return values.get(index);
    }

    public void print() {
        values.forEach(result -> System.out.printf("%6s", result.getValue()));
        System.out.println();
    }
}
