package view;

import domain.Connection;
import domain.Ladder;
import domain.Line;

public class OutputView {
    public void printLadderState(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            StringBuilder sb = new StringBuilder();
            for (Connection conn : line.getConnections()) {
                sb.append("|");
                sb.append(conn.isConnectedRight() ? "-----" : "     ");
            }
            sb.append("|");
            System.out.println(sb.toString());
        }
    }
}
