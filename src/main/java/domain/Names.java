package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> values;

    private Names(List<Name> values) {
        this.values = values;
    }

    public static Names from(String input) {
        List<Name> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(names);
    }

    public int size() {
        return values.size();
    }


    public void print() {
        values.forEach(name -> System.out.printf("%6s", name.getValue()));
        System.out.println();
    }

    public List<Name> getValues() {
        return values;
    }
}
