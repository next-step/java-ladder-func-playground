package view;

import java.util.List;

public class LadderOutputView {

    public void printLadder(List<List<Boolean>> ladders) {
        for (List<Boolean> l : ladders) {
            System.out.print("|");
            for (Boolean b : l) {
                if (b) {
                    System.out.print("----");
                } else {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
