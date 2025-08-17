import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import domain.Columns;
import domain.Ladder;
import domain.LadderHeight;
import domain.Participants;
import domain.RungLength;
import service.LadderNavigator;
import service.RandomConnectionGenerator;
import view.LadderRenderer;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Participants participants = readParticipants(scanner);
            List<String> labels = readLabels(scanner, participants.size());
            int heightCount = readHeight(scanner);
            Ladder ladder = buildLadder(participants.size(), heightCount);
            renderLadder(participants.names(), labels, ladder);
            queryAndPrintResults(scanner, participants, labels, ladder);
        }
    }

    private static Participants readParticipants(Scanner scanner) {
        while (true) {
            List<String> names = readCommaSeparated(scanner, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            try { return Participants.of(names); }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }

    private static List<String> readLabels(Scanner scanner, int count) {
        while (true) {
            List<String> labels = readCommaSeparated(scanner, "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            if (labels.size() != count) { System.out.println("결과의 개수는 참여자 수(" + count + ")와 같아야 합니다"); continue; }
            return labels;
        }
    }

    private static List<String> readCommaSeparated(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return Arrays.stream(scanner.nextLine().trim().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private static int readHeight(Scanner scanner) {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static Ladder buildLadder(int numNames, int heightCount) {
        Columns columns = Columns.of(numNames);
        LadderHeight height = LadderHeight.of(heightCount);
        RandomConnectionGenerator generator = new RandomConnectionGenerator(new Random());
        return generator.generateLadder(height, columns);
    }

    private static void renderLadder(List<String> names, List<String> labels, Ladder ladder) {
        Columns columns = Columns.of(names.size());
        RungLength rungLength = RungLength.defaultFive();
        LadderRenderer renderer = new LadderRenderer();
        System.out.println("\n사다리 결과\n");
        System.out.println(renderer.renderNamesHeader(names, rungLength));
        renderer.print(ladder, columns, rungLength);
        System.out.println(renderer.renderBottomLabels(labels, rungLength));
    }

    private static void queryAndPrintResults(Scanner scanner, Participants participants, List<String> labels, Ladder ladder) {
        Columns columns = Columns.of(participants.size());
        LadderNavigator navigator = new LadderNavigator();
        while (true) {
            String who = promptWho(scanner);
            if (handleSelection(navigator, ladder, columns, participants, labels, who)) break;
        }
    }

    private static String promptWho(Scanner scanner) {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        String who = scanner.nextLine().trim();
        System.out.println("\n실행 결과");
        return who;
    }

    private static boolean handleSelection(
            LadderNavigator navigator,
            Ladder ladder,
            Columns columns,
            Participants participants,
            List<String> labels,
            String who
    ) {
        if (who.equalsIgnoreCase("all")) { handleAllRequest(navigator, ladder, columns, participants, labels); return true; }
        int index = participants.indexOf(who);
        if (index < 0) { System.out.println("존재하지 않는 이름입니다"); return false; }
        printSingleResult(navigator, ladder, columns, index, labels);
        return false;
    }

    private static void handleAllRequest(LadderNavigator navigator, Ladder ladder, Columns columns, Participants participants, List<String> labels) {
        printAllResults(navigator, ladder, columns, participants, labels);
    }

    private static void printAllResults(LadderNavigator navigator, Ladder ladder, Columns columns, Participants participants, List<String> labels) {
        for (int i = 0; i < columns.count(); i++) { printSingleMapping(navigator, ladder, columns, participants, labels, i); }
    }

    private static void printSingleResult(LadderNavigator navigator, Ladder ladder, Columns columns, int index, List<String> labels) {
        int dest = navigator.traverse(ladder, columns, index);
        System.out.println(labels.get(dest));
    }

    private static void printSingleMapping(LadderNavigator navigator, Ladder ladder, Columns columns, Participants participants, List<String> labels, int i) {
        int dest = navigator.traverse(ladder, columns, i);
        String name = participants.get(i);
        String label = labels.get(dest);
        System.out.println(name + " : " + label);
    }
}
