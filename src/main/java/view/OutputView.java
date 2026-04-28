package view;
import domain.*;

import java.util.stream.Collectors;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";

    public void printLadderBoard(Players players, Ladder ladder, Rewards rewards) {
        System.out.println("\n사다리 결과\n");
        printNames(players);
        ladder.getLines().forEach(this::printLine);
        printRewards(rewards);
    }

    private void printNames(Players players) {
        String names = players.getNames().stream()
                .map(name -> String.format("%-6s", name.getValue()))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    private void printRewards(Rewards rewards) {
        String items = rewards.getItems().stream()
                .map(reward -> String.format("%-6s", reward.getValue()))
                .collect(Collectors.joining());
        System.out.println(items);
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(VERTICAL_LINE);
        line.getPoints().forEach(point -> appendPoint(builder, point));
        System.out.println(builder.toString());
    }

    private void appendPoint(StringBuilder builder, boolean isConnected) {
        builder.append(getLineShape(isConnected));
        builder.append(VERTICAL_LINE);
    }

    private String getLineShape(boolean isConnected) {
        if (isConnected) {
            return CONNECTED_LINE;
        }
        return DISCONNECTED_LINE;
    }

    public void printSingleResult(Player player) {
        System.out.println("\n실행 결과");
        System.out.println(player.getReward().getValue());
    }

    public void printAllResults(GameResult gameResult) {
        System.out.println("\n실행 결과");
        gameResult.getAll().forEach(this::printFormattedResult);
    }

    private void printFormattedResult(Player player) {
        System.out.println(player.getName().getValue() + " : " + player.getReward().getValue());
    }
}