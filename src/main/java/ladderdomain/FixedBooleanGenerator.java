package ladderdomain;

import java.util.List;

public class FixedBooleanGenerator implements BooleanValueGenerator {

    private final List<Boolean> values;
    private int index = 0;

    public FixedBooleanGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        return values.get(index++ % values.size());
    }
}

