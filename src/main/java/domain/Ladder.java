package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Participant> participants;
    private final List<Line> lines;

    public Ladder(Size ladderSize, Size lineSize) {
        this.participants = generateParticipants(lineSize);
        this.lines = generateLines(ladderSize, lineSize);
        getResult();
    }

    private List<Participant> generateParticipants(Size lineSize) {
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < lineSize.getSize(); i++) {
            participants.add(new Participant(i));
        }
        return participants;
    }

    private List<Line> generateLines(Size ladderSize, Size lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderSize.getSize(); i++) {
            lines.add(new Line(lineSize));
        }
        return lines;
    }

    private void getResult(){
        for (Line line : lines) {
            changeByLine(line);
        }
    }

    private void changeByLine(Line line){
        for(int i = 0; i< line.getPoints().size() ; i++){
            changeByPoint(i,line.getPoints().get(i));
        }
    }

    private void changeByPoint(int idx, Point point){
        if(point.isConnected()){
            swapEnds(idx);
        }
    }

    private void swapEnds(int idx){
        int temp = participants.get(idx).getEnd();
        participants.get(idx).setEnd(participants.get(idx+1).getEnd());
        participants.get(idx+1).setEnd(temp);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
