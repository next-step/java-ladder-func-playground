package view;


import Model.Bridge;
import Model.BridgeStep;
import Model.Player;
import Model.Rewards;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printBridge(Bridge bridge) {
        for (List<BridgeStep> row : bridge.getRows()) {
            printBrigdeRow(row);
            System.out.print("|");
            System.out.println();
        }

    }

    private void printBrigdeRow(List<BridgeStep> row) {
        row.forEach(bridgeStep -> {
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

    public boolean printRewards(Rewards rewards, Player players, String inputNames) {
        System.out.println("실행 결과");
        String trimmedInput = inputNames.trim();
        if (trimmedInput.equals("all")) {
            players.getPlayers().stream()
                    .forEach(player -> System.out.println(player + " : " + rewards.getRewardskey(players.getDestinatioinPos(player))));
            return true;
        }

        Arrays.stream(trimmedInput.split(","))
                .map(String::trim)
                .forEach(trimmedName -> {
                    try {
                        System.out.println(trimmedName + " : " + rewards.getRewardskey(players.getDestinatioinPos(trimmedName)));
                    } catch (Exception e) {
                        throw new IllegalArgumentException("[ERROR] 존재하지 않는 플레이어 이름입니다: " + trimmedName);
                    }
                });
        return false;
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
