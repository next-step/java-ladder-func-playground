import config.GameConfig;
import domain.LadderGame;
import view.OutputView;

public class LadderGameApp {
    public static void main(String[] args) {
        final int WIDTH = 4;
        final int HEIGHT = 4;
        GameConfig gameConfig = new GameConfig(WIDTH, HEIGHT);
        OutputView outputView = new OutputView();
        LadderGame ladderGame = new LadderGame(gameConfig);
        ladderGame.run();

        outputView.printLadderState(ladderGame.getLadder());
    }
}
