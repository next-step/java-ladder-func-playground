package view;

import domain.ladder.Line;
import domain.player.PlayerResult;
import java.util.List;

public class OutputView {

    private static final String LADDER_GAME_RESULT_COMMAND = "사다리 결과";
    private static final String GAME_RESULT_COMMAND = "실행 결과";
    private static final String VERTICAL_BAR = "|";
    private static final String BRIDGE_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String NEW_SPACE = " ";

    public void printLadderGamePlayerNamesPrompt() {
        print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printLadderGameResultPrompt() {
        print(NEW_LINE);
        print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderHeightPrompt() {
        print(NEW_LINE);
        print("최대 사다리 높이는 몇 개인가요?");
    }

    public void printPlayerNameForResultPrompt() {
        print("결과를 보고 싶은 사람은?");
    }

    public void printLadderGameResult(List<Line> lines, List<String> names, List<String> results) {
        print(NEW_LINE);
        print(LADDER_GAME_RESULT_COMMAND);
        print(renderValues(names));

        for (Line line : lines) {
            print(renderLine(line));
        }

        print(renderValues(results));
        print(NEW_LINE);
    }

    public void printAllResult(List<PlayerResult> playerResults) {
        print(NEW_LINE);
        print(GAME_RESULT_COMMAND);
        print(getMatchingResult(playerResults));
    }

    public void printOneResult(String resultByName) {
        print(NEW_LINE);
        print(resultByName);
    }

    public void printError(String message) {
        print(message);
    }

    private String renderValues(List<String> values) {
        return String.join(NEW_SPACE, values);
    }

    private String renderLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_BAR);

        for (boolean hasBridge : line.points()) {
            sb.append(segmentFor(hasBridge));
            sb.append(VERTICAL_BAR);
        }

        return sb.toString();
    }

    private String segmentFor(boolean hasBridge) {
        if (hasBridge) {
            return BRIDGE_SEGMENT;
        }
        return EMPTY_SEGMENT;
    }

    private String getMatchingResult(List<PlayerResult> playerResults) {
        StringBuilder sb = new StringBuilder();

        for (PlayerResult playerResult : playerResults) {
            sb.append(playerResult.name());
            sb.append(RESULT_SEPARATOR);
            sb.append(playerResult.result());
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }

    private void print(String value) {
        System.out.println(value);
    }
}
