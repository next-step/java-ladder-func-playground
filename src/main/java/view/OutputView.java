package view;

import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Point;
import java.util.List;

public class OutputView {

    public void printResultText(){
        System.out.println("실행결과");
    }

    public void printLadder(Ladder ladder){
        for(Line line : ladder.getLines()){
            printLine(line);
            System.out.println();
        }
    }

    public void printLine(Line line){
        for(Point point : line.getPoints()){
            System.out.print("|");
            System.out.print(PointString.getPointString(point).getString());
        }
        System.out.print("|");
    }

    public void printResult(List<Participant> participants){
        for(Participant participant : participants){
            System.out.println(participant.getStart() + " -> " + participant.getEnd());
        }
    }
}
