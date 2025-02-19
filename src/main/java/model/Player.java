package model;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}