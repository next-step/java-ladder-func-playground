package domain;

public class LadderWidth {
    private final int value;

    public LadderWidth(int value) {
        if (value < 2) {
            throw new IllegalArgumentException("사다리의 넓이는 2 이상이어야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
