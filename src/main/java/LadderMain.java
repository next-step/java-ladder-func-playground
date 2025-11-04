import controller.LadderGameController;
import model.ladder.generator.RandomConnectionGenerator;
import view.ConsolePrinter;
import view.ConsoleReader;
import view.InputReader;
import view.InputView;
import view.OutputView;
import view.Printer;

import java.util.Scanner;

public class LadderMain {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();

        InputReader reader = new ConsoleReader(new Scanner(System.in));

        RandomConnectionGenerator generator = new RandomConnectionGenerator();

        InputView inputView = new InputView(printer, reader);

        OutputView outputView = new OutputView(printer);

        LadderGameController controller = new LadderGameController(
                inputView,
                outputView,
                generator
        );

        controller.startGame();
    }
}
