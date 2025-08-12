package model;

import exception.ErrorMessage;

public class Player {

    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LIMIT_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
