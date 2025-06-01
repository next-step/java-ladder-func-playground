package view;

import domain.Connection;
import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Reward;
import domain.Rewards;
import java.util.Map;

public class OutputView {
    private static final String CONNECTION = "-----";
    private static final String NOT_CONNECTION = "     ";
    private static final String LADDER = "|";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String NAME_FORMAT = "%5s ";
    private static final String REWARD_FORMAT = "%5s ";
    private static final String INDENT = "    ";

    public void printLadderState(Ladder ladder, Players players, Rewards rewards) {
        System.out.println("\n사다리 결과\n");
        printNames(players);
        for (Line line : ladder.getLines()) {
            System.out.println(printLine(line));
        }
        printRewards(rewards);
        System.out.println();
    }

    private void printNames(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf(NAME_FORMAT, player.name());
        }
        System.out.println();
    }

    private void printRewards(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.printf(REWARD_FORMAT, reward.name());
        }
        System.out.println();
    }

    private String printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(INDENT);
        for (Connection conn : line.getConnections()) {
            sb.append(LADDER);
            sb.append(printConnection(conn));
        }
        sb.append(LADDER);
        return sb.toString();
    }

    private String printConnection(Connection conn) {
        if (conn.connectedRight()) {
            return CONNECTION;
        }
        return NOT_CONNECTION;
    }

    public void printLadderResult(LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        for (Map.Entry<Player, Reward> entry : ladderResult.getResultMap().entrySet()) {
            System.out.printf(RESULT_FORMAT + "%n", entry.getKey().name(), entry.getValue().name());
        }
    }

    public void printTargetReward(String targetPlayerName, LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        Reward reward = ladderResult.findRewardByPlayerName(targetPlayerName);
        System.out.printf(RESULT_FORMAT + "%n", targetPlayerName, reward.name());
    }

}
