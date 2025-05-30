package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> values;

    private Names(List<Name> values) {
        validateDuplicates(values);
        this.values = values;
    }

    public static Names from(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("참가자 이름을 입력해주세요.");
        }

        List<Name> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());

        if (names.isEmpty()) {
            throw new IllegalArgumentException("유효한 참가자 이름을 입력해주세요.");
        }

        return new Names(names);
    }

    private void validateDuplicates(List<Name> names) {
        long uniqueCount = names.stream().distinct().count();
        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("중복된 참가자 이름이 있습니다.");
        }
    }

    public int size() {
        return values.size();
    }

    public List<Name> getValues() {
        return values;
    }

    public int indexOf(Name name) {
        return values.indexOf(name);
    }
}
