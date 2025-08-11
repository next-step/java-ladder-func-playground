package domain;

public final class Columns {
    private final int count;

    private Columns(int count) {
        this.count = count;
    }

    public static Columns of(int count) {
        if (count < 2) {
            throw new IllegalArgumentException("열의 개수는 2 이상이어야 합니다");
        }
        return new Columns(count);
    }

    public static Columns fixedFour() {
        return of(4);
    }

    public int count() {
        return count;
    }

    public int numberOfSegments() {
        return count - 1;
    }
}


