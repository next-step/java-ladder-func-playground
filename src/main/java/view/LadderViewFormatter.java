// LadderViewFormatter.java (NEW FILE)
package view; // 또는 controller, formatter 등

import Model.*; // Model 객체(날재료)를 받습니다.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// '조립'의 책임을 전부 이 클래스가 가집니다.
public class LadderViewFormatter {

    // printBridge 로직을 그대로 가져옵니다.
    // 'void'가 아니라, '완성된 문자열 리스트'를 반환합니다.
    public List<String> formatBridge(Bridge bridge) {
        List<String> bridgeLines = new ArrayList<>();
        for (BridgeRow row : bridge.getRows()) {
            // printBridgeRow의 로직을 합칩니다.
            String line = row.getSteps().stream()
                    .map(this::formatBridgeStep) // printBridgeStep 로직 호출
                    .collect(Collectors.joining("|", "|", "|")); // "|결과|결과|" 형태로 조립
            bridgeLines.add(line);
        }
        return bridgeLines;
    }

    // printBridgeStep 로직을 가져옵니다.
    // 'void'가 아니라, '완성된 문자열'을 반환합니다.
    private String formatBridgeStep(BridgeStep bridgeStep) {
        if (bridgeStep == BridgeStep.EXIST) {
            return "-----";
        }
        return "     ";
    }

    // printPlayersAndRewards 로직을 가져옵니다.
    public String formatNamesLine(List<String> names) {
        // 6칸 포맷팅 로직을 수행하고 하나의 문자열로 반환합니다.
        return names.stream()
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining());
    }

    // printAllResults 로직을 가져옵니다.
    public List<String> formatAllResults(Player players, Rewards rewards, LadderResult ladderResult) {
        List<String> resultLines = new ArrayList<>();
        for (int i = 0; i < players.getPlayersNumber(); i++) {
            String playerName = players.getPlayerName(i);
            int destinationIndex = ladderResult.getDestinationIndex(i);
            String reward = rewards.getReward(destinationIndex);

            // "조립"만 하고 리스트에 추가합니다.
            resultLines.add(playerName + " : " + reward);
        }
        return resultLines; // '출력'하지 않고 '반환'합니다.
    }

    // printSpecificResults도 마찬가지입니다...
    // (이 로직은 Controller와 Formatter가 나눠서 처리하는 것이 더 좋습니다만, 
    //  일단은 포맷팅만 분리하는 것을 목표로 합시다.)
}
