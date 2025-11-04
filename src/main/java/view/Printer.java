package view;

public interface Printer {

    void print(String message);

    void printFormat(String format, Object... args);

    void printLine();

    void printLine(String message);

    void printError(String errorMessage);
}
