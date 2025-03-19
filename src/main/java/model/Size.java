package model;

import exception.ExceptionMessage;

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
            throw new IllegalArgumentException(ExceptionMessage.LADDER_SIZE_NEGATIVE.getMessage());
        }
    }
}
