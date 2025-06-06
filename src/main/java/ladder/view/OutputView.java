package ladder.view;

import java.util.List;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.Name;
import ladder.model.Participants;
import ladder.model.Results;

public class OutputView {

    public void printLadder(Ladder ladder, Participants participants, List<String> results) {
        System.out.println("\n사다리 결과\n");
        printParticipants(participants);
        ladder.draw();
        printResults(results);
    }

    private void printParticipants(Participants participants) {
        System.out.print("  ");
        for (Name name : participants.values()) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    public void printResults(List<String> results) {
        System.out.print("  ");
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println("\n");
    }

    public void printSingleResult(String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public void printAllResults(Results results) {
        System.out.println("\n실행 결과");
        IntStream.range(0, results.getParticipants().size())
            .forEach(i -> System.out.printf("%s : %s%n",
                results.getParticipants().get(i),
                results.getAll().get(i)));
    }
}
