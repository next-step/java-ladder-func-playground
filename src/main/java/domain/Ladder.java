package domain;

import java.util.*;
import java.util.stream.*;

public class Ladder {
    private final List<LadderRow> lines;

    public Ladder(int width, int height, LadderRowStrategy strategy) {//세로줄 개수, 사다리 높이(line개수), 줄 랜덤 생성
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new LadderRow(width, strategy))
                .collect(Collectors.toList());
    }//height만큼 line 생성됨

    public int climb(int start) {
        int current = start;
        for (LadderRow line : lines) {
            current = line.move(current);
        }
        return current; //최종 인덱스 출력
    }

    public List<LadderRow> getLines() { return lines; }
}
