package view;

import java.util.List;
import java.util.Map;

public class LadderOutputView {

    public static final String LADDER_COLUMN = "l";
    public static final String LADDER_CONNECTED = "----";
    public static final String LADDER_UNCONNECTED = "     ";

    public void printLadderCanvas(List<String> names, List<List<Boolean>> ladders, List<String> results) {
        System.out.println(String.join(" ", names));
        ladders.forEach(this::printLine);
        System.out.println(String.join(" ", results));
    }

    private void printLine(List<Boolean> line) {
        System.out.print(LADDER_COLUMN);
        line.stream()
                .map(point -> convertToPoint(point) + LADDER_COLUMN)
                .forEach(System.out::print);
        System.out.println();
    }

    private String convertToPoint(Boolean point) {
        if (point) {
            return LADDER_CONNECTED;
        }
        return LADDER_UNCONNECTED;
    }

    public void printAllLadderResult(Map<String, String> results) {
        System.out.println("실행 결과");
        results.forEach((name, result) -> System.out.println(name + "->" + result));
    }

    public void printLadderResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
