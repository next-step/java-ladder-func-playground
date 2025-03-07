package view;

public enum LineCharacter {
    VERTICAL("|"),
    CONNECTED("-----"),
    DISCONNECTED("     ");

    private final String symbol;

    LineCharacter(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
