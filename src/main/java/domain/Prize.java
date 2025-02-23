package domain;

public class Prize {
    private final String name;

    public Prize(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품은 비어있을 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}