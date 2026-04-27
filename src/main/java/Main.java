import controller.GenerateLadderGameController;
import controller.LadderResultOutputController;
import model.Ladder;
import model.LadderBuilder;
import model.LadderGame;
import model.LineBuilder;
import model.RandomizedLineBuilder;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineBuilder lineBuilder = new RandomizedLineBuilder();
        LadderBuilder ladderBuilder = new LadderBuilder(lineBuilder);
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        GenerateLadderGameController generateLadderGameController = new GenerateLadderGameController(ladderBuilder, inputView);
        LadderGame ladderGame = generateLadderGameController.generateLadderGame();

        LadderResultOutputController ladderResultOutputController = new LadderResultOutputController(ladderGame, outputView);
        ladderResultOutputController.printLadderResults();
    }
}
