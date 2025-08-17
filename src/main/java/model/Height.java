package model;

import util.SizeValidator;

public class Height {

    private final int height;

    public Height(int height) {
        SizeValidator.validateNotNegative(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
