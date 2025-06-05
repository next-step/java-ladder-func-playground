package ladder.view;

import java.util.List;

public class LadderOutputView {

    private static String LEG = "----";
    private static String BLANK = "    ";

    public void printLine(List<Boolean> line) {
        if (line == null || line.isEmpty()) {
            System.out.println("|");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");

        for (boolean isConnected : line) {
            stringBuilder.append(getJoiner(isConnected));
            stringBuilder.append("|");
        }

        System.out.println(stringBuilder);
    }

    private String getJoiner(boolean isConnected) {
        if (isConnected) {
            return LEG;
        }
        return BLANK;
    }
}
