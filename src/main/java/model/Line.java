package model;

import java.util.List;

import util.LadderRandomGenerator;

public class Line {
    
    private final List<Boolean> points;

    public Line(int length) {
        this.points = LadderRandomGenerator.generateRandomLine(length);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isPoint(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
        return points.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean point : points) {
            sb.append("|");
            sb.append(point ? "-----" : "     ");
        }
        sb.append("|");
        return sb.toString();
    }
}
