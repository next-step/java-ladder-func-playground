package view;

import model.Ladder;
import model.LadderResult;

import model.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

public class OutputView {

    public void printLadder(Ladder ladder){
        System.out.println("실행결과");
        for(Line line: ladder.getLadder()){
            printLine(line);
        }
    }

    public void printLine(Line line){
        System.out.print("ㅣ");
        for(int i=0;i< line.getWidth();i++){
            System.out.print(line.getLine().get(i) ? "-----ㅣ" : "     ㅣ");
        }
        System.out.println(" ");
    }

    public void printLadderResult(LadderResult ladderResult){
        for(Map.Entry<Integer,Integer> entry:ladderResult.getLadderResult().entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
