package domain;

public class Height {
    private final int value;

    public Height(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Height는 0보다 커야한다");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
