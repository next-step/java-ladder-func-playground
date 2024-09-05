package domain;

public class CustomBooleanGenerator implements BooleanGenerator {
    private final boolean customBoolean;

    public CustomBooleanGenerator(boolean customBoolean) {
        this.customBoolean = customBoolean;
    }

    @Override
    public boolean generateBoolean() {
        return customBoolean;
    }
}
