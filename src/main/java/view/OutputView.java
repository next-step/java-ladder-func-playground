package view;

import java.util.List;
import java.util.stream.Collectors;

import model.Ladder;
import model.Line;
import model.Player;
import model.Players;
import model.Result;

public class OutputView {
    public void outLadder(Players players, Ladder ladder, List<String> choices) {
        System.out.println("실행 결과\n");

        System.out.println(
            players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(" "))
        );
        for (Line line : ladder.getLines()) {
            System.out.println("\t" + formatLine(line));
        }
        System.out.println(
            String.join(" ", choices)
        );

        System.out.println();
    }

    private String formatLine(Line line) {
        return line.getPoints().stream()
            .map(bool -> Boolean.TRUE.equals(bool) ? "-----" : "     ")
            .collect(Collectors.joining("|", "|", "|"));
    }

    public void outResult(String target, Result result) {
        System.out.printf("실행 결과%n%s%n", result.get(target));
    }

    public void outAllResult(Result result) {
        System.out.println("실행 결과");
        for (String player : result.keys()) {
            System.out.printf("%s : %s%n", player, result.get(player));
        }
    }
}
