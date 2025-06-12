package ladder.view;

import java.util.List;
import java.util.stream.IntStream;
import ladder.model.LadderResult;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Name;
import ladder.model.Participants;
import ladder.model.Result;

public class OutputView {

    public void printLadder(Ladder ladder, Participants participants, List<Result> results) {
        System.out.println("\n사다리 결과\n");
        printParticipants(participants);
        printLadderLines(ladder);
        printResults(results);
    }

    private void printParticipants(Participants participants) {
        for (Name name : participants.getParticipantsNameList()) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    private void printLadderLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        for (Boolean point : line.getPoints()) {
            System.out.print("|");
            printLineSegment(point);
        }
        System.out.println("|");
    }

    private void printLineSegment(Boolean connected) {
        if (connected) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }

    public void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println("\n");
    }

    public void printSingleResult(Result result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public void printAllResults(LadderResult results) {
        System.out.println("\n실행 결과");
        IntStream.range(0, results.getParticipants().size())
            .forEach(i -> System.out.printf("%s : %s%n",
                results.getParticipants().get(i),
                results.getAll().get(i)));
    }
}
