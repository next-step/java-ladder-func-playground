package ladder.message;

public enum ConsoleMessage {
    RESULT("실행결과"),
    ;

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
