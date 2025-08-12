package model;

public class Player {

    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
