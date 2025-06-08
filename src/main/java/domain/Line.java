package domain;

import java.util.List;

public class Line {

    //points : 각 지점의 연결점들
    //Line : 한 층
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public String toLine() {

        StringBuilder sb = new StringBuilder();

        sb.append("|");

        for (boolean point : points) {
            sb.append(isConnected(point));
        }
        return sb.toString();
    }

    public String isConnected(boolean point) {
        if (point) {
            return "-----|";
        } else {
            return "     |";
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
