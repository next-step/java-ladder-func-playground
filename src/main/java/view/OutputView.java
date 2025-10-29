package view;

import domain.Ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLadder(List<String> ladderString) {
        for(String singleRow:ladderString){
            System.out.println(singleRow);
        }
    }

    public void printColInput(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
    }

    public void printRowInput(){
        System.out.println("사다리의 높이는 몇 개인가요?");
    }

    public void printSingleIndexStartEnd(int start, int end){
        System.out.printf(start + " -> " + end);
    }

    public void printResultStartEnd(HashMap<Integer, Integer> resultMap) {
        for (Map.Entry<Integer, Integer> startEnd : resultMap.entrySet()) {
            printSingleIndexStartEnd(startEnd.getKey(), startEnd.getValue());
        }
    }
}
