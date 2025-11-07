package view;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printFormat(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Override
    public void printLine() {
        System.out.print(System.lineSeparator());
    }

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
