package view;

import java.util.List;

public class OutputView {
    public void print(List<String> lines) {
        for (String line : lines) {
            printLine(line);
        }
    }

    public void printLine(String line) {
        System.out.println(line);
    }
}
