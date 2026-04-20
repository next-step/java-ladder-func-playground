package view;

import dto.PrizeResult;

import java.util.List;

public class OutputView {
    private static final int TEXT_WIDTH = 4;
    private static final int LADDER_WIDTH = 4;

    public void printLadder(List<List<Boolean>> ladder, List<String> playerName, List<String> prizes) {
        System.out.println("사다리 결과");

        for (String name : playerName) {
            System.out.print(padCenter(name));
        }
        System.out.println();
        ladder.forEach(this::printRow);
        for (String prize : prizes) {
            System.out.print(padCenter(prize));
        }
        System.out.println();
    }

    public void printAllResult(List<PrizeResult> prizeResults) {
        for (PrizeResult prizeResult : prizeResults) {
            System.out.println(prizeResult.playerName() + " : " + prizeResult.prize());
        }
    }

    private String padCenter(String text) {
        int padding = TEXT_WIDTH - text.length();
        if (padding < 0) {
            padding = 0;
        }
        int left = padding / 2;
        int right = padding - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

    private void printRow(List<Boolean> row) {
        for (Boolean aBoolean : row) {
            System.out.print("|");
            printConnection(aBoolean);
        }
        System.out.println("|");
    }

    private void printConnection(boolean isConnected) {
        if (isConnected) {
            System.out.print("-".repeat(LADDER_WIDTH));
            return;
        }
        System.out.print(" ".repeat(LADDER_WIDTH));
    }
}
