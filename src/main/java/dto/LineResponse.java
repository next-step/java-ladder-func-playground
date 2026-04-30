package dto;

import domain.LadderLow;

import java.util.List;

public record LineResponse(List<Boolean> lines) {
    public static LineResponse from(LadderLow line) {
        return new LineResponse(List.copyOf(line.getConnections()));
    }
}
