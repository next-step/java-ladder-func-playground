package domain;

public final class LadderHeight {
    private final int count;

    private LadderHeight(int count) {
        this.count = count;
    }

    public static LadderHeight of(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("행의 개수는 1 이상이어야 합니다");
        }
        return new LadderHeight(count);
    }

    public int count() {
        return count;
    }
}


