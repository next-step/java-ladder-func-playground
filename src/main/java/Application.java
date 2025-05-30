import strategy.RandomLinkStrategy;
import view.OutputView;

public class Application {
    static private final int LADDER_ROW = 4;
    static private final int LADDER_COLUMN = 4;

    public static void main(String[] args) {
        LadderGame game = new LadderGame(LADDER_ROW, LADDER_COLUMN, new RandomLinkStrategy()); //그냥 맨 사다리 만듬

        // 결과 출력
        OutputView.printLadder(game.getLadder());
    }
}



