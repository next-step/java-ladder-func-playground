package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final Size lineSize;
    private final List<Point> points;

    public Line(int lineSize) {
        this.lineSize = new Size(lineSize);
        this.points = generatePoints(lineSize);
    }

    public List<Point> generatePoints(int lineSize) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < lineSize; i++) {
            generatePoint(points);
        }
        return points;
    }

    public void generatePoint(List<Point> points) {
        if(points.isEmpty()){
            points.add(new Point(new RandomBooleanGenerator()));
            return;
        }
        generateNext(points);
    }

    public void generateNext(List<Point> points) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        int lastIndex = points.size() - 1;
        if(points.get(lastIndex).isConnected()){
            booleanGenerator = new CustomBooleanGenerator(false);
        }
        points.add(new Point(booleanGenerator));
    }

    public List<Point> getPoints() {
        return points;
    }
}