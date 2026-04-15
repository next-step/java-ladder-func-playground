package view;

import java.util.List;

public class OutputView {
    public void printLadder(List<List<Boolean>> ladder) {
        System.out.println("실행결과");
        ladder.forEach(this::printRow);
    }

    private void printRow(List<Boolean> row) {
        for (Boolean aBoolean : row) {
            System.out.print("|");
            printConnection(aBoolean);
        }
        System.out.println("|");
    }

    private void printConnection(boolean isConnected){
        if (isConnected) {
            System.out.print("-".repeat(4));
            return;
        }
        System.out.print("    ");
    }
}
