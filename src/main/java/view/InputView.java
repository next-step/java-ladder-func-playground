package view;

public class InputView {

    private final Printer printer;
    private final InputReader reader;

    public InputView(Printer printer, InputReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public String inputPeople() {
        printer.printLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return reader.readLine();
    }

    public String inputResults() {
        printer.printLine("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return reader.readLine();
    }

    public int inputLadderHeight() {
        printer.printLine("사다리의 높이는 몇 개인가요?");
        return Integer.parseInt(reader.readLine());
    }

    public String inputPlayerName() {
        printer.printLine("결과를 보고 싶은 사람은?");
        return reader.readLine();
    }
}
