package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;
    private final Random random = new Random();

    public Line(int lineSize) {
        this.points = generatePoints(lineSize);
    }

    public List<Point> generatePoints(int lineSize) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < lineSize; i++) {
            generatePoint(points);
        }
        return points;
    }

    private void generatePoint(List<Point> points) {
        if(points.isEmpty()){
            points.add(new Point(getRandomBoolean()));
            return;
        }
        generateNext(points);
    }

    private void generateNext(List<Point> points) {
        boolean isConnected = false;
        int lastIndex = points.size() - 1;
        if(!points.get(lastIndex).isConnected()){
            isConnected = getRandomBoolean();
        }
        points.add(new Point(isConnected));
    }

    private boolean getRandomBoolean(){
        return random.nextBoolean();
    }

    public List<Point> getPoints() {
        return points;
    }
}