package domain;

public final class Rows {
    private final int count;

    private Rows(int count) {
        this.count = count;
    }

    public static Rows of(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("행의 개수는 1 이상이어야 합니다");
        }
        return new Rows(count);
    }

    public static Rows fixedFour() {
        return of(4);
    }

    public int count() {
        return count;
    }
}


