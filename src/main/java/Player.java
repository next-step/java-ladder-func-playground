public class Player {
    private final String name;
    private final int startPosition;

    public Player(String name, int startPosition) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
        this.name = name;
        this.startPosition = startPosition;
    }

    public String getName() {
        return name;
    }

    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public String toString() {
        return name;
    }
}
