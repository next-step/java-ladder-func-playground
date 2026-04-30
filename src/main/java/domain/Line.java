package domain;

import java.util.List;

public class Line {
    private final List<Boolean> line;
    private final int width;

    public Line(int width,List<Boolean> line) {
        this.width = width;
        this.line = line;
    }

    public List<Boolean> getLine() {
        return line;
    }

    public int move(int playerPosition) {
        Direction direction=findDirection(playerPosition);
        return direction.move(playerPosition);
    }

    private Direction findDirection(int playerPosition){
        if(playerPosition>0 &&line.get(playerPosition-1)){
            return Direction.LEFT;
        }
        if(playerPosition<line.size() &&line.get(playerPosition)){
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }
    public int getWidth() {
        return width;
    }
}
