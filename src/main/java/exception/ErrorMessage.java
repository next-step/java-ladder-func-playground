package exception;

public enum ErrorMessage {

    NOT_INTEGER_FORMAT("int 타입 정수가 아닌 값이 입력되었습니다."),
    NEGATIVE_NUMBER("음수가 입력되었습니다."),
    EMPTY_NAME("이름이 비어있습니다."),
    NAME_LENGTH("이름이 5글자를 넘었습니다."),
    PLAYER_NAMES_EMPTY("참여자가 존재하지 않습니다"),
    PRIZE_EMPTY("당첨 결과가 비어있습니다."),
    PRIZES_EMPTY("당첨 결과 리스트가 비어있습니다."),
    PLAYER_NOT_FOUND("해당 플레이어를 찾을 수 없습니다."),
    NULL_INPUT_STRING("입력 문자열로 null이 입력 되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
