package view;

import Model.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printBridge(Bridge bridge) {
        for (BridgeRow row : bridge.getRows()) {
            printBridgeRow(row);
            System.out.print("|");
            System.out.println();
        }
    }

    private void printBridgeRow(BridgeRow row) {
        row.getSteps().forEach(bridgeStep -> {
            System.out.print("|");
            printBridgeStep(bridgeStep);
        });
    }

    public void printPlayersAndRewards(List<String> strings) {
        strings.forEach(string -> System.out.printf("%-6s", string));
        System.out.println();
    }

    private void printBridgeStep(BridgeStep bridgeStep) {
        if (bridgeStep == BridgeStep.EXIST) {
            System.out.print("-----");
        } else {
            System.out.print("     ");
        }
    }

    public void askResults() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printAllResults(Player players, Rewards rewards, LadderResult ladderResult) {
        for (int i = 0; i < players.getPlayersNumber(); i++) {
            String playerName = players.getPlayerName(i);
            int destinationIndex = ladderResult.getDestinationIndex(i);
            String reward = rewards.getReward(destinationIndex);
            System.out.println(playerName + " : " + reward);
        }
    }

    public void printSpecificResults(Player players, Rewards rewards, LadderResult ladderResult, String specificNames) {
        Arrays.stream(specificNames.split(","))
                .map(String::trim)
                .forEach(trimmedName -> {
                    try {
                        int playerIndex = players.getPlayerIndex(trimmedName);
                        int destinationIndex = ladderResult.getDestinationIndex(playerIndex);
                        String reward = rewards.getReward(destinationIndex);
                        System.out.println(trimmedName + " : " + reward);
                    } catch (Exception e) {
                        System.out.println("[ERROR] 존재하지 않는 플레이어 이름입니다: " + trimmedName);
                    }
                });
    }

    public void askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void askRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void askLadderHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
    }
}
