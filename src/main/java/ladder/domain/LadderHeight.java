package ladder.domain;

public class LadderHeight {
    private final int value;

    private LadderHeight(int value) {
        this.value = value;
    }

    public static LadderHeight from(int value) {
        validate(value);
        return new LadderHeight(value);
    }

    public int getValue() {
        return value;
    }

    private static void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명 이상이어야 합니다.");
        }
    }

}
