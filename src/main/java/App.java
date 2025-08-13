import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import domain.Columns;
import domain.Ladder;
import domain.Rows;
import domain.RungLength;
import service.LadderNavigator;
import service.RandomConnectionGenerator;
import view.LadderRenderer;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> names = readNames(scanner);
            List<String> labels = readLabels(scanner, names.size());
            int height = readHeight(scanner);
            Ladder ladder = buildLadder(names.size(), height);
            renderLadder(names, labels, ladder);
            queryAndPrintResults(scanner, names, labels, ladder);
        }
    }

    private static List<String> readNames(Scanner scanner) {
        while (true) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = Arrays.stream(scanner.nextLine().trim().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            if (names.isEmpty()) { System.out.println("이름을 한 개 이상 입력해 주세요"); continue; }
            if (!names.stream().allMatch(n -> n.length() <= 5)) { System.out.println("각 이름은 최대 5글자까지 가능합니다"); continue; }
            return names;
        }
    }

    private static List<String> readLabels(Scanner scanner, int count) {
        while (true) {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            List<String> labels = Arrays.stream(scanner.nextLine().trim().split(","))
                    .map(String::trim)
                    .toList();
            if (labels.size() != count) { System.out.println("결과의 개수는 참여자 수(" + count + ")와 같아야 합니다"); continue; }
            return labels;
        }
    }

    private static int readHeight(Scanner scanner) {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static Ladder buildLadder(int numNames, int height) {
        Columns columns = Columns.of(numNames);
        Rows rows = Rows.of(height);
        RandomConnectionGenerator generator = new RandomConnectionGenerator(new Random());
        return generator.generateLadder(rows, columns);
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

    private static void queryAndPrintResults(Scanner scanner, List<String> names, List<String> labels, Ladder ladder) {
        Columns columns = Columns.of(names.size());
        LadderNavigator navigator = new LadderNavigator();
        while (true) {
            String who = promptWho(scanner);
            if (handleSelection(navigator, ladder, columns, names, labels, who)) break;
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
            List<String> names,
            List<String> labels,
            String who
    ) {
        if (who.equalsIgnoreCase("all")) { printAllResults(navigator, ladder, columns, names, labels); return true; }
        int index = names.indexOf(who);
        if (index < 0) { System.out.println("존재하지 않는 이름입니다"); return false; }
        int dest = navigator.traverse(ladder, columns, index);
        System.out.println(labels.get(dest));
        return false;
    }

    private static void printAllResults(
            LadderNavigator navigator,
            Ladder ladder,
            Columns columns,
            List<String> names,
            List<String> labels
    ) {
        for (int i = 0; i < columns.count(); i++) {
            int dest = navigator.traverse(ladder, columns, i);
            String name = names.get(i);
            String label = labels.get(dest);
            System.out.println(name + " : " + label);
        }
    }
}
