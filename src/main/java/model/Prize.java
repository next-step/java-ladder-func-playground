package model;

public class Prize {

    private final String value;

    public Prize(String value) {
        validateValue(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateValue(String value) {
        if(value == null || value.isEmpty()) {
            throw new IllegalArgumentException("실행결과는 null이거나 공백일 수는 없습니다.");
        }
    }
}

