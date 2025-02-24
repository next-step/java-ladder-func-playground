package view;

import java.util.Map;

import dto.LadderGameResponse;

public class ResultView {

    private static final String VERTICAL = "|";
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";

    public static void outputLadder(LadderGameResponse ladderGameResponse) {
        System.out.println(ladderGameResponse.formattedPlayerNames());
        for (var line : ladderGameResponse.ladder()) {
            printLine(line);
        }
        System.out.println(ladderGameResponse.formattedPrizeNames());
    }

    private static void printLine(Iterable<Boolean> line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        for (Boolean point : line) {
            sb.append(getElement(point));
            sb.append(VERTICAL);
        }
        System.out.println(sb);
    }

    private static String getElement(Boolean point) {
        if (point) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void outputAllPlayerResult(Map<String, String> ladderGameResult) {
        outputResultHeader();
        StringBuilder sb = new StringBuilder();
        ladderGameResult.forEach((key, value) ->
            sb.append(key).append(" : ").append(value).append(System.lineSeparator())
        );
        System.out.print(sb);
    }

    public static void outputPlayerResult(String player, Map<String, String> ladderGameResult) {
        outputResultHeader();
        String prize = ladderGameResult.get(player);
        System.out.println(prize);
    }

    private static void outputResultHeader() {
        System.out.println("실행결과");
    }
}
