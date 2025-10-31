package domain;

public class Height {
    private static final int HEIGHT_MIN = 0;
    private final int height;

    public Height(int height) {
        if (height < HEIGHT_MIN) {
            throw new IllegalArgumentException("사다리 높이는 양수여야 합니다.");
        }

        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.valueOf(height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Height)) return false;
        Height other = (Height) obj;
        return height == other.getHeight();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(height);
    }
}
