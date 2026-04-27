package model;

import dto.LadderResultDto;

import java.util.List;

public record Ladder(List<Line> lineList) {
    public LadderResultDto calculateSingleResultAsDto(Integer index) {
        int result = this.calculateResult(index);
        return new LadderResultDto(index, result);
    }

    private Integer calculateResult(Integer startIndex) {
        Integer result = startIndex;

        for (Line line : lineList) {
            result = line.moveAlongTheRow(result);
        }

        return result;
    }

    public Integer calculateWidth() {
        return lineList.get(0).calculateWidth() + 1;
    }

    public Integer calculateHeight() {
        return lineList.size();
    }

    @Override
    public String toString() {
        return String.join("\n", this.lineList.stream().map(Line::toString).toList());
    }
}
