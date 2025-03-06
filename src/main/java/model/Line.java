package model;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String SPACE = "     |";
    private static final String BRIDGE = "-----|";
    private static final String BAR = "|";

    //TODO: first-class collection
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validatePoints(points);
        this.points = List.copyOf(points);

    }

    private void validatePoints(List<Boolean> points){
        if (!(isTrueSequence(points) && isIncludeTrue(points))) {
            throw new IllegalArgumentException("points는 True가 없거나 연속된 True를 가지고 있습니다.");
        }
    }

    private Boolean isTrueSequence(List<Boolean> points){

        return IntStream.range(1, points.size())
                .noneMatch(i -> points.get(i) && points.get(i-1));
    }

    public Boolean isIncludeTrue(List<Boolean> points){

        return points.stream().anyMatch(Boolean::booleanValue);
    }

    public Boolean getValue(int index) {
        return points.get(index);
    }

    public void print() {
        System.out.print(BAR);
        for (Boolean point : points) {
            System.out.print(getSymbol(point));
        }System.out.println();
    }


    private String getSymbol(Boolean point) {
        if (point) {
            return BRIDGE;
        }
        return SPACE;
    }
}
