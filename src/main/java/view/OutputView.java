package view;

import domain.GameResult;
import domain.LadderGame;
import domain.Player;
import domain.Players;
import domain.Prize;
import domain.Prizes;
import domain.Result;
import java.util.List;

public class OutputView {
    private static final int CELL_WIDTH = 6;

    public void printLadderGameBoard(LadderGame ladderGame) {
        printHeader(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
        printBottom(ladderGame.getPrizes());
    }

    private void printHeader(Players players) {
        StringBuilder builder = new StringBuilder();
        for (Player player : players.getPlayers()) {
            builder.append(pad(player.getName().getValue()));
        }
        System.out.println(builder.toString());
    }

    private void printLadder(domain.Ladder ladder) {
        List<String> lines = ladder.getLadderBody();
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private void printBottom(Prizes prizes) {
        StringBuilder builder = new StringBuilder();
        for (Prize prize : prizes.getPrizes()) {
            builder.append(pad(prize.getValue()));
        }
        System.out.println(builder.toString());
    }

    private String pad(String text) {
        StringBuilder builder = new StringBuilder(text);
        while (builder.length() < CELL_WIDTH) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public void printResultSingle(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printResultAll(GameResult gameResult) {
        for (Result result : gameResult.getResults()) {
            System.out.println(result.getPlayerName() + " : " + result.getPrize());
        }
    }
}
