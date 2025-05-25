package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderPath {

    private final List<BridgeLine> bridgeLines;
    private final int numberOfColumns;

    public LadderPath(List<BridgeLine> bridgeLines, int numberOfColumns) {
        this.bridgeLines = bridgeLines;
        this.numberOfColumns = numberOfColumns;
    }

    public Map<Integer, Integer> mapStartToEndIndex() {
        return IntStream.range(0, numberOfColumns)
                .boxed()
                .collect(
                        LinkedHashMap::new,
                        (map, i) -> map.put(i, tracePathFrom(i)),
                        Map::putAll
                );
    }

    private int tracePathFrom(int startColumnIndex) {
        int currentPosition = startColumnIndex;

        for (BridgeLine bridgeLine : bridgeLines) {
            currentPosition = bridgeLine.nextPositionFrom(currentPosition);
        }

        return currentPosition;
    }
}
