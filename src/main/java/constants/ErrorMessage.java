package constants;

public enum ErrorMessage {
    CONSECUTIVE_STEPS_IN_A_ROW("가로 라인이 겹칩니다!"),
    LINE_NOT_LONG_ENOUGH("가로 라인이 겹칩니다!"),
    NOT_A_NUMBER("입력값이 숫자여야 합니다."),
    ENTRY_NOT_PRESENT("사다리에 존재하지 않는 값입니다."),
    NAME_LONGER_THAN_LIMIT("이름이 5글자를 초과했습니다!"),
    DUPLICATE_NAMES("이름에 중복이 있으면 안됩니다."),
    MADE_IMPOSSIBLE_GAME("사다리 게임 크기 불일치"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
