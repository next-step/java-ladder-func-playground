package domain;

public class Prize {

    public static final int MAX_PRIZE_LENGTH = 5;

    private final String label;

    private Prize(String label) {
        this.label = label;
    }

    public static Prize create(String label) {
        validate(label);
        return new Prize(label);
    }

    public String label() {
        return label;
    }

    private static void validate(String label) {
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("상품을 입력해 주세요.");
        }
        if (label.length() > MAX_PRIZE_LENGTH) {
            throw new IllegalArgumentException("상품은 5자 이하만 가능합니다: " + label);
        }
    }
}
