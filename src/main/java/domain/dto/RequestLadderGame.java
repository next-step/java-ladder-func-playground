package domain.dto;

public class RequestValidateInput {

    private final String value;

    public RequestValidateInput(final String value) {
        validateEmpty(value);
        this.value = value;
    }

    private void validateEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("입력 값은 공백이 아니어야 합니다.");
        }
    }

    protected String raw() {
        return value.strip();
    }
}
