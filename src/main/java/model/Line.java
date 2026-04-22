package model;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> line = new ArrayList<>();
    int width;

    public Line(int width) {
        this.width = width;
        this.line = LineGenerator.makeLine(width);
    }

    public List<Boolean> getLine() {
        return line;
    }

    public int move(int playerPosition) {
        if (playerPosition > 0 && line.get(playerPosition - 1)) {
            return playerPosition - 1;
        }
        if (playerPosition < line.size() && line.get(playerPosition)) {
            return playerPosition + 1;
        }
        return playerPosition;
    }

    public int getWidth() {
        return width;
    }
}
