package strategy;

public class FixedGenerator implements PointGenerator {

    private final boolean[] values;
    private int index = 0;

    public FixedGenerator(final boolean[] values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        return values[index++];
    }
}
