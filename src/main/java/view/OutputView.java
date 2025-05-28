package view;

import domain.Connection;
import domain.Ladder;
import domain.Line;

public class OutputView {
    private static final String CONNECTION = "-----";
    private static final String NOT_CONNECTION = "     ";
    private static final String LADDER = "|";

    public void printLadderState(Ladder ladder) {
        System.out.println("실행결과");
        for (Line line : ladder.getLines()) {
            System.out.println(printLine(line));
        }
    }

    private String printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Connection conn : line.getConnections()) {
            sb.append(LADDER);
            sb.append(printConnection(conn));
        }
        sb.append(LADDER);
        return sb.toString();
    }

    private String printConnection(Connection conn) {
        if (conn.isConnectedRight()) {
            return CONNECTION;
        }
        return NOT_CONNECTION;
    }

    public void printLadderResult(Ladder ladder) {

    }
}
