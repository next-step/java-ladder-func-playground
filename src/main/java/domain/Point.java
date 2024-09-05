package domain;

public class Point {
    private boolean isConnected;
    private final BooleanGenerator booleanGenerator;

    public Point(BooleanGenerator booeleanGenerator) {
        this.booleanGenerator = booeleanGenerator;
        this.isConnected = booeleanGenerator.generateBoolean();
    }

    public boolean isConnected() {
        return isConnected;
    }
}
