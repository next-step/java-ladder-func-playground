package model;

public class Size {
    private final int size;

    public Size(int size) {
        validateSize(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void validateSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사다리 사이즈가 0보다 작을 수는 없습니다.");
        }
    }
}
