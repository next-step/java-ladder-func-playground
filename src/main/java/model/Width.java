package model;

import util.SizeValidator;

public class Width {

    private final int width;

    public Width(int width) {
        SizeValidator.validateNotNegative(width);
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
