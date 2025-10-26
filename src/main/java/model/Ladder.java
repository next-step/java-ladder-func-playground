package model;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = Objects.requireNonNull(lines);
    }

    // 값이 변함 안변하는 자료구조나 방어적 복사 찾아보기
    public List<Line> lines() {
        return lines;
    }
}

