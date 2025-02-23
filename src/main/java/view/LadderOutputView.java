package view;

import java.util.List;
import java.util.Map;

public class LadderOutputView {

    public void printLadderCanvas(List<String> names, List<List<Boolean>> ladders, List<String> results) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
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
        for (String result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }

    public void printAllLadderResult(Map<String, String> result) {
        System.out.println("실행 결과");
        for (Map.Entry<String, String> entry : result.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print("->");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }

    public void printLadderResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
