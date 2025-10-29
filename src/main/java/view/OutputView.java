package view;

import domain.Ladder;

import java.util.List;

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
}
