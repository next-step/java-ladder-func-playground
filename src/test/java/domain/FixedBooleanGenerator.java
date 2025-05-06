package domain;

import java.util.ArrayList;
import java.util.List;

public class FixedBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> values;

    public FixedBooleanGenerator(Boolean... values) {
        this.values = new ArrayList<>(List.of(values));
    }

    @Override
    public Boolean generate() {
        return values.remove(0);
    }
}
