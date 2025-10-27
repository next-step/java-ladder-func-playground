package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void print(List<String> lines) {
        System.out.println("실행결과");
        for (String line : lines) {
            printLine(line);
        }
    }

    public void printLine(String line) {
        System.out.println(line);
    }

    public void printResults(Map<Integer, Integer> results) {
        System.out.println();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + " -> " + results.get(i));
        }
    }
}
