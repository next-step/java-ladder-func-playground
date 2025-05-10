package domain.user;

public class PlayerName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public PlayerName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }
        String trimmed = name.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        if (name.equals("all") || name.equals("exit")) {
            throw new IllegalArgumentException("예약어는 이름으로 사용할 수 없습니다.");
        }

        this.name = trimmed;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayerName other = (PlayerName) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
