package view;

import domain.ladder.LadderLineConnection;

import java.util.List;

public class OutputView {

    private static final String EDGE_OF_LADDER = "|";

    public void printEmpty() {
        System.out.println(" ");
    }

    public void printUser(final String userName) {
        System.out.print(userName + " ");
    }

    public void printResult(final String result) {
        System.out.print(result + " ");
    }

    public void printLadderLine(final List<Boolean> connections) {
        final List<String> line = connections.stream()
                .map(connection -> LadderLineConnection.of(connection).getLadderConnectionFormat())
                .toList();
        System.out.println(String.join("", line) + EDGE_OF_LADDER);
    }

    public void printUserResult(final String result) {
        System.out.println(result);
        System.out.println(" ");
    }

    public void printAllUserResults(final String name, final String result) {
        System.out.println(name + " : " + result);
    }

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }
}
