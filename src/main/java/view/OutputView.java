package view;

import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import java.util.List;
import java.util.Map;

public class OutputView {

    // 사다리와 이름, 결과를 모두 출력
    public static void printLadderGame(LadderGame game, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printNames(game.getNames());
        printLadder(ladder);
        printResults(game.getResults());
    }

    // 이름들을 적절한 간격으로 출력
    private static void printNames(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(String.format("%6s", name)); // 6자리로 맞춤
        }
        System.out.println(sb);
    }

    // 기존 사다리 출력
    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            String lineString = line.toLine();
            System.out.println(lineString);
        }
    }

    // 결과들을 적절한 간격으로 출력
    private static void printResults(List<String> results) {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(String.format("%6s", result)); // 6자리로 맞춤
        }
        System.out.println(sb);
    }

    // 개인 결과 출력
    public static void printPersonResult(String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    // 전체 결과 출력
    public static void printAllResults(Map<String, String> results) {
        System.out.println("\n실행 결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
