package dto;

import domain.Line;

import java.util.List;

public record LineResponse(List<Boolean> lines) {
    public static LineResponse from(Line line) {
        return new LineResponse(List.copyOf(line.getPoints()));
    }
}
