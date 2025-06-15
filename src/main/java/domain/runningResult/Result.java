package domain.runningResult;

public record Result(
        String value
) {

    public Result {
        validateEmptyResult(value);
    }

    private void validateEmptyResult(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 공백이 아니어야 합니다.");
        }
    }
}
