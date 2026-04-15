package view;

import java.util.List;

public class OutputView {
    public void printLadder(List<List<Boolean>> ladder) {
        ladder.forEach(this::printRow);
    }

    private void printRow(List<Boolean> row) {
        for (int i = 0; i < row.size(); i++) {
            System.out.print("|");
            printConnection(row.get(i));
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
