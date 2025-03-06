package model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        isNotIncludeTrueLine(lines);
        this.lines = lines;
    }

    private Boolean isNotIncludeTrueLine(List<Line> lines){
        for (int i = 0; i < lines.size(); i++) {
            List<Boolean> seperatedLine = seperateLines(lines, i);

            return isIncludeTrue(seperatedLine);
        }

        return false;
    }

    private List<Boolean> seperateLines(List<Line> lines, int number){
        List<Boolean> seperatedLine = new ArrayList<>();
        for (Line line : lines) {
            seperatedLine.add(line.getValue(number));
        }

        return seperatedLine;
    }

    private Boolean isIncludeTrue(List<Boolean> points){

        return points.stream().anyMatch(Boolean::booleanValue);
    }

    public List<Line> getLines() {
        return lines;  // 저장된 Line 객체 리스트를 반환
    }

}
