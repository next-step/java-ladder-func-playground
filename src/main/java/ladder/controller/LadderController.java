package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LinkConnector;
import ladder.view.LadderOutputView;

import java.util.List;
import java.util.Scanner;

public class LadderController {
    private final LadderOutputView ladderOutputView = new LadderOutputView();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사다리의 넓이(|의 가로 개수)는 몇 개인가요?");
        int width = scanner.nextInt();

        System.out.println("사다리의 높이(|의 새로 개수)는 몇 개인가요");
        int height = scanner.nextInt();
        System.out.println("실행결과");

        if (width < 2 || height < 1) {
            System.out.println("넓이는 최소 2, 높이는 최소 1 이상 입력해주세요");
            return;
        }

        LinkConnector linkConnector = new LinkConnector();
        Ladder ladder = new Ladder(width, height, linkConnector);
        List<List<Boolean>> lines = ladder.getLines();

        for (List<Boolean> line : lines) {
            ladderOutputView.printLine(line);
        }

    }
}
