package dto;

import domain.LadderBridge;

import java.util.List;

public record LineResponse(List<Boolean> lines) {
    public static LineResponse from(LadderBridge line) {
        return new LineResponse(List.copyOf(line.getConnections()));
    }
}
