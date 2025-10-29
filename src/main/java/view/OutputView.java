package view;

import domain.Ladder;

import java.util.List;

public class OutputView {
    public void printLadder(List<String> ladderString) {
        for(String singleRow:ladderString){
            System.out.println(singleRow);
        }
    }
}
