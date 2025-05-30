package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> values;

    private Results(List<Result> values) {
        this.values = values;
    }

    public static Results from(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("실행 결과를 입력해주세요.");
        }

        List<Result> results = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Result::new)
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            throw new IllegalArgumentException("유효한 실행 결과를 입력해주세요.");
        }

        return new Results(results);
    }

    public Result get(int index) {
        if (index < 0 || index >= values.size()) {
            throw new IndexOutOfBoundsException("잘못된 결과 인덱스입니다: " + index);
        }

        return values.get(index);
    }

    public List<Result> getValues() {
        return values;
    }
}
