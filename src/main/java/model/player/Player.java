package model.player;

public class Player {
    private static final int NAME_LENGTH_LIMIT = 5;

    private int position;
    private String name;

    public Player(int position, String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("참가자 이름이 " + NAME_LENGTH_LIMIT + "자 초과입니다.");
        }
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
