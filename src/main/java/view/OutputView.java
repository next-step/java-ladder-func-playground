package view;


import Model.LadderResult;
import Model.Player;
import Model.Rewards;

import java.util.List;

public class OutputView {

    public void printBridge(List<String> bridgeLines) {
        for (String line : bridgeLines) {
            System.out.println(line);
        }
    }

    public void printNamesLine(String namesLine) {
        System.out.println(namesLine);
    }

    public void printRewards(String rewardLines) {
        System.out.println(rewardLines);
    }

    public void printPlayerNotFoundError(String trimmedName) {
        System.out.println("[ERROR] 존재하지 않는 플레이어 이름입니다: " + trimmedName);
    }


    public void askResults() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    public void askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void askRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void askLadderHeight() {
        System.out.println("\n사다리의 높이는 몇 개인가요?");
    }

    public void printAllResults(Player players, Rewards rewards, LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < players.getPlayersNumber(); i++) {
            int destinationIndex = ladderResult.getDestinationIndex(i);
            System.out.println(players.getPlayerName(i) + " : " + rewards.getReward(destinationIndex));
        }
    }

    public void printSpecificResults(Player players, Rewards rewards, LadderResult ladderResult, String query) {
        int playerIndex = players.getPlayerIndex(query);
        if (playerIndex == -1) {
            printPlayerNotFoundError(query);
            return;
        }
        int destinationIndex = ladderResult.getDestinationIndex(playerIndex);
        System.out.println("\n실행 결과");
        System.out.println(rewards.getReward(destinationIndex));
    }
}
