package domain;

public class Size {
    private int size;

    public Size(int size) {
        validateSize(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void validateSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
    }
}
