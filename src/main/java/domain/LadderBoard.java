package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBoard {

    private static final Random RANDOM = new Random();
    private static final int MAX_ATTEMPTS = 100;
    private static final int MIN_PARTICIPANTS = 2;
    private static final int MIN_HEIGHT = 1;

    private static final String ERROR_TOO_FEW_PARTICIPANTS = "[ERROR] 사다리는 최소 2명 이상의 참가자가 필요합니다.";
    private static final String ERROR_INVALID_HEIGHT = "[ERROR] 사다리 높이는 1 이상이어야 합니다.";
    private static final String ERROR_GENERATION_FAILED = "[ERROR] 사다리를 생성하지 못했습니다. 참가자 수나 높이를 확인해 주세요.";

    private final int columnCount;
    private final List<BridgeLine> lines;

    private LadderBoard(int columnCount, List<BridgeLine> lines) {
        this.columnCount = columnCount;
        this.lines = lines;
    }

    public static LadderBoard build(int columnCount, int rowCount) {
        validate(columnCount, rowCount);
        int centerColumnIndex = (columnCount - 1) / 2;

        List<BridgeLine> bridgeLines = tryGenerateBridgeLines(columnCount, rowCount, centerColumnIndex);
        return new LadderBoard(columnCount, bridgeLines);
    }

    public int getColumnCount() {
        return columnCount;
    }

    public List<BridgeLine> getLines() {
        return lines;
    }

    private static void validate(int columnCount, int rowCount) {
        if (columnCount < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(ERROR_TOO_FEW_PARTICIPANTS);
        }
        if (rowCount < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_INVALID_HEIGHT);
        }
    }

    private static List<BridgeLine> tryGenerateBridgeLines(int participantCount, int ladderHeight, int centerColumnIndex) {
        return IntStream.range(0, MAX_ATTEMPTS)
                .mapToObj(i -> generateAttempt(participantCount, ladderHeight))
                .filter(lines -> isValidBridgeLines(lines, participantCount, centerColumnIndex))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ERROR_GENERATION_FAILED));
    }

    private static List<BridgeLine> generateAttempt(int participantCount, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> new BridgeLine(generateConnectionStates(participantCount)))
                .collect(Collectors.toList());
    }

    private static boolean isValidBridgeLines(List<BridgeLine> lines, int participantCount, int centerColumnIndex) {
        return hasCenterBridge(lines, centerColumnIndex) &&
                hasAllColumnConnections(lines, participantCount - 1);
    }

    private static boolean hasCenterBridge(List<BridgeLine> lines, int centerIndex) {
        return lines.stream().anyMatch(line -> isConnectedAtCenter(line, centerIndex));
    }

    private static boolean hasAllColumnConnections(List<BridgeLine> lines, int expectedCount) {
        Set<Integer> connectedIndices = new HashSet<>();
        lines.forEach(line -> recordConnectedIndices(connectedIndices, getConnectionStates(line)));
        return connectedIndices.size() == expectedCount;
    }

    private static List<Boolean> getConnectionStates(BridgeLine line) {
        return IntStream.range(0, line.width())
                .mapToObj(line::isConnectedAt)
                .collect(Collectors.toList());
    }

    private static List<Boolean> generateConnectionStates(int participantCount) {
        return IntStream.range(0, participantCount - 1)
                .boxed()
                .collect(ArrayList::new, (list, i) -> {
                    boolean canConnect = i == 0 || !list.get(i - 1);
                    list.add(canConnect && RANDOM.nextBoolean());
                }, List::addAll);
    }

    private static boolean isConnectedAtCenter(BridgeLine line, int centerIndex) {
        return centerIndex < line.width() && line.isConnectedAt(centerIndex);
    }

    private static void recordConnectedIndices(Set<Integer> connectedColumnIndices, List<Boolean> connectionStates) {
        IntStream.range(0, connectionStates.size())
                .filter(i -> connectionStates.get(i))
                .forEach(connectedColumnIndices::add);
    }
}
