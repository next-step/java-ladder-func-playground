package view;

import domain.Connect;
import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Players;
import domain.Point;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printAskPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
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

    public void printRetryInputMessage() {
        System.out.println("다시 입력해주세요.");
    }

    public void printException(Exception e) {
        if (e.getMessage() == null) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }
        System.out.println(e.getMessage());
    }

    private void printPlayers(List<Name> players) {
        for (Name name : players) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    private void printResults(List<Name> results) {
        for (Name result : results) {
            System.out.printf("%6s", result);
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
        for (Point point : line.getPoints()) {
            printPoint(point.point());
        }
    }

    private void printPoint(Connect point) {
        if (point.isConnected()) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public void printLadder(Ladder ladder, List<Name> players, List<Name> results) {
        printPlayers(players);
        printLines(ladder.getLines());
        printResults(results);
    }


    public void printSingleResult(String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public void printAllResults(Map<String, String> results, Players players) {
        System.out.println("\n실행 결과");
        for (Name name : players.getPlayers().getValues()) {
            System.out.println(name.value() + " : " + results.get(name.value()));
        }
    }
}
