import domain.Ladder;
import view.OutputView;

public class Application {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame();
        Ladder ladder = ladderGame.createLadder();
        OutputView output = new OutputView();
        output.printLadder(ladder);
    }
}
