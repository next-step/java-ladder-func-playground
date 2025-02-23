package enumurate;

public enum LadderElementEnum {

    VERTICAL("|"),
    CONNECTED("-----"),
    DISCONNECTED("     "),
    ;

    public final String element;

    LadderElementEnum(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }
}
