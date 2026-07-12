package view;

import domain.LadderGame;
import domain.LadderLine;
import domain.Point;

import java.util.List;

public class LadderPrinter {

    private static final String POINT = "|";
    private static final String CONNECT_LINE = "-";
    private static final String NO_CONNECT = " ";
    private static final int CONNECTION_WIDTH = 5;

    public static void printLadder(LadderGame ladderGame) {
        List<LadderLine> ladderLines = ladderGame.getLadderStructure();
        ladderLines.forEach(line -> {
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append(POINT);  // 첫 번째 포인트

            List<Point> points = line.getPoints();
            int lastIndex = points.size() - 1;

            for (int i = 0; i < lastIndex; i++) {
                appendConnection(lineBuilder, points.get(i));
                lineBuilder.append(POINT);  // 다음 포인트
            }
            System.out.println(lineBuilder); // 한 줄 출력
        });
    }

    private static void appendConnection(StringBuilder lineBuilder, Point point) {
        if (point.move(0, CONNECTION_WIDTH) == 1) {
            lineBuilder.append(CONNECT_LINE.repeat(CONNECTION_WIDTH));
            return;
        }
        lineBuilder.append(NO_CONNECT.repeat(CONNECTION_WIDTH));
    }
}
