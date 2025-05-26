package view;

import domain.BridgeLine;
import dto.LadderBuildResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String PARTICIPANT_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_PROMPT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_PROMPT = "사다리의 높이는 몇 칸인가요?";
    private static final String RESULT_SELECTION_PROMPT = "결과를 보고 싶은 사람은?";
    private static final String LADDER_RESULT_TITLE = "실행 결과";
    private static final String NAME_NOT_FOUND_MESSAGE = "해당 이름은 존재하지 않습니다.";

    private static final int DISPLAY_CELL_WIDTH = 6;
    private static final String CELL_FORMAT = "%-" + DISPLAY_CELL_WIDTH + "s";
    private static final String RESULT_FORMAT = "%s : %s";

    private static final String VERTICAL_BAR = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String INDENT = " ";

    public void printParticipantPrompt() {
        System.out.println(PARTICIPANT_PROMPT);
    }

    public void printResultPrompt() {
        System.out.println(RESULT_PROMPT);
    }

    public void printHeightPrompt() {
        System.out.println(HEIGHT_PROMPT);
    }

    public void printResultSelectionPrompt() {
        System.out.println(RESULT_SELECTION_PROMPT);
    }

    public void printLadderTitle() {
        System.out.println(LADDER_RESULT_TITLE);
    }

    public void printNameNotFound() {
        System.out.println(NAME_NOT_FOUND_MESSAGE);
    }

    public void printParticipantNames(List<String> participantNames) {
        System.out.println(joinAligned(participantNames));
    }

    public void printResultLabels(List<String> resultLabels) {
        System.out.println(joinAligned(resultLabels));
    }

    public void printBridgeLines(LadderBuildResponse response) {
        int columnCount = response.columnCount();
        List<BridgeLine> lines = response.lines();

        lines.forEach(line -> System.out.println(INDENT + formatBridgeLine(line, columnCount)));
    }

    public void printAllResults(Map<String, String> participantResults) {
        participantResults.forEach((name, result) ->
                System.out.println(formatResult(name, result)));
    }

    public void printSingleResult(String resultValue) {
        System.out.println(resultValue);
    }

    public void printSingleResultWithTitle(String resultValue) {
        printLadderTitle();
        printSingleResult(resultValue);
    }

    private String formatBridgeLine(BridgeLine line, int columnCount) {
        return IntStream.range(0, columnCount)
                .mapToObj(i -> VERTICAL_BAR + bridgeRepresentation(line, i))
                .collect(Collectors.joining());
    }

    private String bridgeRepresentation(BridgeLine line, int index) {
        if (line.isConnectedAt(index)) return CONNECTED_LINE;
        return EMPTY_LINE;
    }

    private String joinAligned(List<String> values) {
        return values.stream()
                .map(this::formatCell)
                .collect(Collectors.joining());
    }

    private String formatCell(String value) {
        return String.format(CELL_FORMAT, value);
    }

    private String formatResult(String name, String result) {
        return String.format(RESULT_FORMAT, name, result);
    }
}
