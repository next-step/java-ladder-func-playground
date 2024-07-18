package ladder.message;

public enum ConsoleMessage {
    RESULT("실행결과"),
    LADDER_RESULT("사다리 결과"),
    LADDER_WIDTH("사다리의 넓이는 몇 개인가요?"),
    LADDER_HEIGHT("사다리의 높이는 몇 개인가요?"),
    INPUT_NAME("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_RESULT("실행 결과를 입력하세요. (결과는 쉽표(,)로 구분하세요)"),
    RESULT_TARGET("결과를 보고 싶은 사람은?");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
