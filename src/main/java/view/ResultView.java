package view;

import java.util.List;

public class ResultView {

    public void printString(String content){
        System.out.println(content);
    }

    public void printLadderLine(List<Boolean> points, int ladderSpace){
        System.out.print("|");
        for(Boolean point : points){
            printPoint(ladderSpace, point);

        }
        System.out.print("\n");
    }

    public void printLadderPlayResult(int start, int end){
        System.out.println(String.format("%d -> %d", start, end));
    }

    private void printPoint(int ladderSpace, Boolean point) {
        if(point){
            printTruePoint(ladderSpace);
        }else{
            printFalsePoint(ladderSpace);
        }
    }

    private void printTruePoint(int ladderSpace){
        for (int i = 0; i < ladderSpace; i++){
            System.out.print("-");
        }
        System.out.print("|");
    }

    private void printFalsePoint(int ladderSpace){
        for (int i = 0; i < ladderSpace; i++){
            System.out.print(" ");
        }
        System.out.print("|");
    }
}