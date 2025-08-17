import java.util.Random;
import java.util.Scanner;

import controller.LadderGameController;
import model.LadderGenerator;
import view.InputView;
import view.LadderView;
import view.LineView;
import view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        LineView lineView = new LineView();
        LadderView ladderView = new LadderView(lineView);
        OutputView outputView = new OutputView(ladderView);
        InputView inputView = new InputView(new Scanner(System.in));
        LadderGenerator ladderGenerator = new LadderGenerator(new Random());

        LadderGameController ladderGameController = new LadderGameController(ladderGenerator, outputView, inputView);

        ladderGameController.run();
    }
}
