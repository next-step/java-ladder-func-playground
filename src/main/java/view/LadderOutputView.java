package view;

import java.util.List;
import java.util.Map;

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

    public void printLadderResult(Map<Integer, Integer> result) {
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print("->");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }
}
