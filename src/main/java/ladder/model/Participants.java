package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants from(String input) {
        return new Participants(
            Arrays.stream(input.split(","))
                  .map(String::trim)
                  .map(Name::new)
                  .collect(Collectors.toList())
        );
    }

    public int size() {
        return names.size();
    }

    public List<Name> values() {
        return new ArrayList<>(names);
    }
}
