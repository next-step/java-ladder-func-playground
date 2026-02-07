package ladder.domain;

public class LadderWidth {
    private final int value;

    private LadderWidth(int value) {
        this.value = value;
    }

    public static LadderWidth from(int value) {
        validate(value);
        return new LadderWidth(value);
    }

    public int getPointCount() { // 다리 수 = 참여자 수 -1
        return value - 1;
    }

    public int getValue() {
        return value;
    }

    private static void validate(int value) {
        if (value < 2) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명 이상이어야 합니다.");
        }
    }
}
