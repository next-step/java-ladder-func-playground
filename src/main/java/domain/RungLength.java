package domain;

public final class RungLength {
    private final int length;

    private RungLength(int length) {
        this.length = length;
    }

    public static RungLength of(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("길이는 1 이상이어야 합니다");
        }
        return new RungLength(length);
    }

    public static RungLength defaultFive() {
        return of(5);
    }

    public int length() {
        return length;
    }

    public String dashes() {
        return "-".repeat(length);
    }

    public String spaces() {
        return " ".repeat(length);
    }
}


