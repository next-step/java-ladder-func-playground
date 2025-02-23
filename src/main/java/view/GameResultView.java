package view;

import domain.Player;
import java.util.List;

public class GameResultView {
    public void printString(String content){
        System.out.println(content);
    }

    public void printPlayerName(String player){
        int totalWidth = 5;
        int nameLength = player.length();
        int padding = totalWidth - nameLength;

        // 양쪽 공백 계산
        int leftPadding = padding / 2 + (padding % 2);
        int rightPadding = padding / 2;

        System.out.print(" ".repeat(leftPadding)); // 왼쪽 공백
        System.out.print(player);
        System.out.print(" ".repeat(rightPadding)); // 오른쪽 공백
    }

    public void printLadderLine(List<Boolean> points, int ladderSpace){
        System.out.print("|");
        for(Boolean point : points){
            printPoint(ladderSpace, point);

        }
        System.out.print("\n");
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

    public void printPairOfPlayerWithPrize(String player, String prize){
        System.out.println(String.format("%s : %s", player, prize));
    }
}