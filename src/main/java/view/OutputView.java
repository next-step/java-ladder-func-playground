package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLadder(List<String> participants, List<String> lines, List<String> results) {
        System.out.println();
        System.out.println("실행결과");

        for (String name : participants) {
            System.out.print(String.format("%-5s", name));
        }
        System.out.println();

        for (String line : lines) {
            System.out.println(line);
        }

        for (String result : results) {
            System.out.print(String.format("%-5s", result));
        }
        System.out.println();
    }
    public void printSingleResult(String name, String result) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(result);
    }

    public void printAllResults(Map<String, String> results) {
        System.out.println();
        System.out.println("실행결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
