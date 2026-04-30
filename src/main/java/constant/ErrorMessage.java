package constant;

public enum ErrorMessage {
    INVALID_INTEGER("정수를 입력하세요."),
    NOT_POSITIVE_NUMBER("0보다 큰 값을 입력하세요."),
    EMPTY_OR_BLANK_NAME("이름은 비어 있거나 공백일 수 없습니다."),
    NOT_FOUND_NAME("존재하지 않는 이름입니다."),
    PLAYER_NOT_FOUND("해당 참가자가 없습니다."),
    INVALID_NAME_LENGTH("이름은 최대 %d글자까지 가능합니다."),
    INVALID_LADDER_HEIGHT("사다리 높이는 %d 이상이어야 합니다."),
    INVALID_LADDER_WIDTH("사다리 너비는 %d 이상이어야 합니다."),
    MISMATCH_PLAYER_AND_PRIZE("인원 수와 상품 수는 같아야 합니다."),
    DUPLICATE_PLAYER_NAME("참가자의 이름에는 중복이 없어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getIntFormattedMessage(int num) {
        return String.format(message, num);
    }
}
