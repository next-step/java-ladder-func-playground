package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {
    private List<List<Boolean>> lines;

    public Ladder(int width, int height, LinkConnector linkConnector) {
        Random random = new Random();
        List<List<Boolean>> generatedLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            generatedLines.add(linkConnector.generate(width));
        }

        int col = width -1;
        boolean[] hasBridgeArray = new boolean[col];
        for (List<Boolean> line : generatedLines) {
        for (int j = 0; j < col; j++) {
            hasBridgeArray[j] = hasBridgeArray[j] | line.get(j);
            }
        }

        List<Integer> notHasBridgeArray = new ArrayList<>();
        for (int j = 0; j < col; j++) {
            boolean b = !hasBridgeArray[j] && notHasBridgeArray.add(j);
        }

        for (int j : notHasBridgeArray) {
            int i = random.nextInt(height);
            generatedLines.get(i).set(j,true);
        }
        lines = generatedLines;
    }

    public List<List<Boolean>> getLines() {
        return List.copyOf(lines);
    }
}
