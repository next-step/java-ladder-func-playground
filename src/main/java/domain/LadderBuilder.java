package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private static final String LadderVertical = "|";
    private static final String LadderHorizontal = "-----";
    private static final String EmptyHorizontal = "     ";


    public String buildSingleLadderCol(LinePoints linePoints) {
        StringBuilder ladderString = new StringBuilder();
        ladderString.append(LadderVertical);
        for (boolean linePoint : linePoints.getLinePoints()) {
            ladderString.append(linePoint ? LadderHorizontal : EmptyHorizontal);
            ladderString.append(LadderVertical);
        }
        return ladderString.toString();
    }

    public List<String> buildLadder(Ladder ladder) {
        List<String> ladderStrings = new ArrayList<>();
        for (LinePoints linePoints : ladder.getLines()) {
            ladderStrings.add(buildSingleLadderCol(linePoints));
        }
        return ladderStrings;
    }
}
