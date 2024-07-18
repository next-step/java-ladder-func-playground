package ladder.message;

public enum ConsoleMessage {
    RESULT("실행결과"),
    LADDER_WIDTH("사다리의 넓이는 몇 개인가요?"),
    LADDER_HEIGHT("사다리의 높이는 몇 개인가요?"),
    ;

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
