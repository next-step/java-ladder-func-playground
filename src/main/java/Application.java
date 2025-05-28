import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final int LADDER_ROW = 4;
        final int LADDER_COLUMN = 4;

        LadderGame game = new LadderGame(LADDER_ROW, LADDER_COLUMN); //그냥 맨 사다리 만듬

        game.initialize(); //사다리 연결 시작
        //Xxxxxx.start() // 사다리 게임 시작

        // 결과 출력
        OutputView.printLadder(game.getLadder());
    }
}



