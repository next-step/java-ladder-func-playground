package view;

import model.LadderGame;

public class OutputView {

    public void printResult(LadderGame ladderGame, String name) {
        System.out.println("실행 결과");
        if (name.equals("all")) {
            printAllResult(ladderGame);
        } else {
            printPlayerResult(ladderGame, name);
        }
    }

    private void printPlayerResult(LadderGame ladderGame, String name) {
        Integer startColumnIndex = ladderGame.getPlayers().getPlayerIndexByName(name);
        Integer resultIndex = ladderGame.getLadder().getResultIndexByPlayerIndex(startColumnIndex);
        System.out.println(ladderGame.getResults().getResultByIndex(resultIndex));
    }

    private void printAllResult(LadderGame ladderGame) {
        for (int i = 0; i < ladderGame.getPlayers().getPlayerCount(); ++i) {
            Integer resultIndex = ladderGame.getLadder().getResultIndexByPlayerIndex(i);
            System.out.println(String.format("%s : %s",
                ladderGame.getPlayers().getPlayerNameByIndex(i),
                ladderGame.getResults().getResultByIndex(resultIndex)
            ));
        }
    }

    public void printLadderGameResult(LadderGame ladderGame) {
        System.out.println("사다리 결과");
        System.out.println(ladderGame.getPlayers());
        System.out.print(ladderGame.getLadder());
        System.out.println(ladderGame.getResults());
    }
}
