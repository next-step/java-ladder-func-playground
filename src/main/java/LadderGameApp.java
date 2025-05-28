import config.GameConfig;
import domain.LadderGame;
import view.InputView;
import view.OutputView;

public class LadderGameApp {
    public static void main(String[] args) {
        GameConfig gameConfig = getGameConfig();
        OutputView outputView = new OutputView();
        LadderGame ladderGame = LadderGame.of(gameConfig);
        ladderGame.play();

        outputView.printLadderState(ladderGame.getLadder());
    }

    private static GameConfig getGameConfig() {
        InputView inputView = new InputView();
        final int width = inputView.getWidth();
        final int height = inputView.getHeight();
        return new GameConfig(width, height);
    }
}
