package view;

import domain.Ladder;
import domain.Line;
import domain.Point;
import domain.PointString;

public class OutputView {

    public void printResult(){
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

}
