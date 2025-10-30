package view;

import domain.Ladder;
import domain.Line;
import domain.Players;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printAskPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼포(,)로 구분하세요)");
    }

    public void printAskResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printAskHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadderResultTitle() {
        System.out.println("\n사다리 결과\n");
    }

    public void printAskResultByPlayer() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    private void printPlayers(List<String> players) {
        for (String name : players) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    private void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.print("      |");
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(Line line) {
        for (boolean point : line.getPoints()) {
            printPoint(point);
        }
    }

    private void printPoint(Boolean point) {
        if (point) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public void printLadder(Ladder ladder, List<String> players, List<String> results) {
        printPlayers(players);
        printLines(ladder.getLines());
        printResults(results);
    }

    private void printResults(List<String> results) {
        for (String result : results) {
            System.out.printf("%6s", result);
        }
        System.out.println();
    }

    public void printSingleResult(String name, String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public void printAllResults(Map<String, String> results, Players players) {
        System.out.println("\n실행 결과");
        for (String name : players.getPlayers().getValues()) {
            System.out.println(name + " : " + results.get(name));
        }
    }
}
