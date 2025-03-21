package view;

import dto.LadderDto;

import java.util.List;

public class LadderView {
    private static final String BRIDGE = "-----|";
    private static final String SPACE = "     |";
    private static final String BAR = "|";

    public static void printLadder(LadderDto ladderDto) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        ladderDto.getLadderData().forEach(LadderView::printLine);
    }

    private static void printLine(List<Boolean> line) {
        System.out.print(BAR);
        line.forEach(LadderView::printPoint);
        System.out.println();
    }

    private static void printPoint(Boolean point) {
        if (point) {
            System.out.print(BRIDGE);
            return;
        }
        System.out.print(SPACE);
    }
}
