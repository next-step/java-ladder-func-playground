package domain;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        validateName(prize);
        this.prize = prize;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("상품은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return prize;
    }
}
