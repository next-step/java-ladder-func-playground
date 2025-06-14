package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderBuilder;
import ladder.model.LadderResult;
import ladder.model.LinkConnector;
import ladder.view.LadderOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderController {

    private final LadderOutputView ladderOutputView = new LadderOutputView();
    private final LadderResult ladderResult = new LadderResult();


    public void run() {
        Scanner scanner = new Scanner(System.in);

        List<String> names;
        while (true) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요, 이름은 5글자까지 허용합니다.)");
            String[] ArrayNames = scanner.nextLine().split(",");
            names = Arrays.stream(ArrayNames)
                    .map(String::trim)
                    .toList();

            boolean nameCount = names.stream().anyMatch(name -> name.length() > 5);

            if (nameCount) {
                System.out.println("이름은 5글자 이내로 입력하세요.");
                continue;
            }
            break;
        }

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .toList();
        // 실행 결과에 기본값을 넣어준다
        if (results.size() < names.size()) {
            int different = names.size() - results.size();
            results = new ArrayList<>(results);
            for (int i = 0; i < different; i++) {
                results.add("꽝");
            }
        } else if (results.size() > names.size()) {
            results = results.subList(0, names.size());
        }

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        if (height < 1) {
            System.out.println("높이는 최소 1 이상이어야 합니다.");
            return;
        }

        int width = names.size();
        LinkConnector connector = new LinkConnector();
        LadderBuilder builder = new LadderBuilder(connector);
        Ladder ladder = builder.build(width, height);

        String LADDER_INTERVAL = "%-5s";
        for (String name : names) {
            System.out.printf(LADDER_INTERVAL, name);
        }
        System.out.println();

        for (List<Boolean> line : ladder.getLines()) {
            ladderOutputView.printLine(line);
        }

        for (String result : results) {
            System.out.printf(LADDER_INTERVAL, result);
        }
        System.out.println();

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String result = scanner.next().strip();
            boolean isAll = "all".equalsIgnoreCase(result);
            boolean isName = names.contains(result);

            if (isAll) {
                int[] resultLadder = ladderResult.resultIndex(ladder);
                for (int i = 0; i < width; i++) {
                    System.out.println(names.get(i) + " : " + results.get(resultLadder[i]));
                }
                break;
            }
            if (isName) {
                int idx = names.indexOf(result);
                int[] resultLadder = ladderResult.resultIndex(ladder);
                System.out.println("실행 결과");
                System.out.println(results.get(resultLadder[idx]));
                continue;
            }
            System.out.println("작성한 이름이나 all을 입력해주세요.");
        }
    }
}
