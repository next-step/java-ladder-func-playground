import controller.GenerateLadderController;
import controller.LadderResultOutputController;
import model.Ladder;
import model.LadderBuilder;
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

        GenerateLadderController generateLadderController = new GenerateLadderController(ladderBuilder, inputView);
        Ladder ladder = generateLadderController.generateLadder();

        LadderResultOutputController ladderResultOutputController = new LadderResultOutputController(ladder, outputView);
        ladderResultOutputController.printLadderResults();
    }
}
