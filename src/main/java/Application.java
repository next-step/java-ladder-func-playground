import domain.Ladder;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        Ladder ladder = Ladder.generate(4, 4);
        ResultView resultView = new ResultView();
        resultView.printLadder(ladder);
    }
}
