package view;
import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Position;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";
    private static final String RESULT_MESSAGE = "\n실행결과\n";

    public void printLadder(Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        ladder.getLines().forEach(this::printLine);
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

    public void printLadderResult(LadderResult result) {
        System.out.println();
        result.getResults().forEach(this::printSingleResult);
    }

    private void printSingleResult(Position start, Position end) {
        System.out.println(start.getValue() + " -> " + end.getValue());
    }
}