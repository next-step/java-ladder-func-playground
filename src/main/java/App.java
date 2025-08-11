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
            List<String> names;
            while (true) {
                System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                names = Arrays.stream(scanner.nextLine().trim().split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .toList();
                if (names.isEmpty()) {
                    System.out.println("이름을 한 개 이상 입력해 주세요");
                    continue;
                }
                boolean allValid = names.stream().allMatch(n -> n.length() <= 5);
                if (!allValid) {
                    System.out.println("각 이름은 최대 5글자까지 가능합니다");
                    continue;
                }
                break;
            }

            System.out.println();
            List<String> labels;
            while (true) {
                System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
                labels = Arrays.stream(scanner.nextLine().trim().split(","))
                        .map(String::trim)
                        .toList();
                if (labels.size() != names.size()) {
                    System.out.println("결과의 개수는 참여자 수(" + names.size() + ")와 같아야 합니다");
                    continue;
                }
                break;
            }

            System.out.println();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = Integer.parseInt(scanner.nextLine().trim());

            Columns columns = Columns.of(names.size());
            Rows rows = Rows.of(height);
            RungLength rungLength = RungLength.defaultFive();

            RandomConnectionGenerator generator = new RandomConnectionGenerator(new Random());
            Ladder ladder = generator.generateLadder(rows, columns);

            System.out.println();
            System.out.println("사다리 결과");
            System.out.println();

            LadderRenderer renderer = new LadderRenderer();
            System.out.println(renderer.renderNamesHeader(names, rungLength));
            renderer.print(ladder, columns, rungLength);
            System.out.println(renderer.renderBottomLabels(labels, rungLength));

            LadderNavigator navigator = new LadderNavigator();
            while (true) {
                System.out.println();
                System.out.println("결과를 보고 싶은 사람은?");
                String who = scanner.nextLine().trim();
                System.out.println();
                System.out.println("실행 결과");
                if (who.equalsIgnoreCase("all")) {
                    printAllResults(navigator, ladder, columns, names, labels);
                    break;
                }
                int index = names.indexOf(who);
                if (index < 0) {
                    System.out.println("존재하지 않는 이름입니다");
                    continue;
                }
                int dest = navigator.traverse(ladder, columns, index);
                System.out.println(labels.get(dest));
            }
        }
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
