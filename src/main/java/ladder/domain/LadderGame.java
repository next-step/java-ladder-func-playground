package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final int width;
    private final List<Integer> result = new ArrayList<>();

    public LadderGame(Ladder ladder, int width) {
        this.ladder = ladder;
        this.width = width;
    }

    public void move() {
        for (int i = 0; i < width; i++) {
            moveHeight(i);
        }
    }

    private void moveHeight(int position) {
        for (int i = 0; i < ladder.getLadder().size(); i++) {
            position = moveLine(ladder.getLadder().get(i), position);
        }
        result.add(position);
    }

    private Integer moveLine(Line line, int position) {
        if (position == 0) {
            if(line.getLine().get(position).equals(true)){
                return ++position;
            }
            return position;
        }
        if (position == line.getWidth() - 1) {
            if(line.getLine().get(position - 1).equals(true)){
                return --position;
            }
            return position;
        }
        if (line.getLine().get(position).equals(true)) {
            return ++position;
        }
        if (line.getLine().get(position - 1).equals(true)) {
            return --position;
        }

        return position;
    }

    public List<Integer> getResult(){
        return result;
    }
}
