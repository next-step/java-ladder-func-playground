package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(){
        this(4,4);
    }

    public Ladder(int ladderWidth, int ladderHeight){
        this.lines = new ArrayList<>();
        for(int i=0; i<ladderHeight; i++){
            lines.add(new Line(ladderWidth));
        }
    }

    public List<Line> getLines(){
        return lines;
    }
}
