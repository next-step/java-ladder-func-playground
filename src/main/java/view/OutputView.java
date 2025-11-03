package view;

import domain.Ladder;
import domain.LinePoints;
import domain.PointConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LadderVertical = "|";
    private static final String LadderHorizontal = "-----";
    private static final String EmptyHorizontal = "     ";

    public void printLadder(List<String> ladderString) {
        for (String singleRow : ladderString) {
            System.out.println(singleRow);
        }
    }

    public void printLadder(Ladder ladder) {
        List<String> ladderString = buildLadder(ladder);
        printLadder(ladderString);
    }

    private String buildSingleLadderCol(LinePoints linePoints) {
        StringBuilder ladderString = new StringBuilder();
        ladderString.append(LadderVertical);
        for (PointConnection linePoint : linePoints.getLinePoints()) {
            ladderString.append(linePoint.isConnected() ? LadderHorizontal : EmptyHorizontal);
            ladderString.append(LadderVertical);
        }
        return ladderString.toString();
    }

    private List<String> buildLadder(Ladder ladder) {
        List<String> ladderStrings = new ArrayList<>();
        for (LinePoints linePoints : ladder.getLines()) {
            ladderStrings.add(buildSingleLadderCol(linePoints));
        }
        return ladderStrings;
    }

    public void printPlayersInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printPrizesInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printRowInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printAskPlayerMessage() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printSingleResultMessage(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public void printAllResultMessage(Map<String, String> resultMap) {
        System.out.println("실행 결과");
        for (Map.Entry<String, String> result : resultMap.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }

    public void printInvalidSelectedPlayerMessage() {
        System.out.println("해당 유저가 존재하지 않습니다.");
    }
}
