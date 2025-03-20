package exception;

public enum ExceptionMessage {
    LADDER_HEIGHT_MIN_VALUE("사다리 높이는 최소 2 이상이어야 합니다."),
    LADDER_SIZE_NEGATIVE("사다리 사이즈가 0보다 작을 수는 없습니다."),
    LADDER_HEIGHT_NOT_NUMBER("사다리 높이는 숫자여야 합니다."),

    PLAYER_NAME_MAX_LENGTH_EXCEEDED("참가자 이름은 최대 5글자를 초과할 수 없습니다."),
    MIN_PLAYERS_REQUIRED("참가자는 최소 2명 이상이여야 합니다."),

    RESULT_COUNT_MISMATCH("실행결과 개수와 참가자의 수는 동일해야 합니다."),
    RESULT_NOT_NULL_OR_EMPTY("실행결과는 null이거나 공백일 수는 없습니다."),
    NULL_OR_EMPTY_INPUT("입력값이 null이거나 비어있을 순 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
