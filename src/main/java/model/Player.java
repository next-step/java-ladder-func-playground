package model;

public class Player {
    private final String name;
    private int x;
    private int y;

    private Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void move(Ladder ladder) {
        while (y < ladder.size() - 1) {
            moveX(ladder);
            y++;
        }
    }

    private void moveX(Ladder ladder) {
        if (ladder.get(x-1, y)) {
            x--;
            return;
        }

        if (ladder.get(x, y)) {
            x++;
        }
    }

    public static Player of(int name, int x, int y) {
        return new Player(String.valueOf(name), x, y);
    }
}
