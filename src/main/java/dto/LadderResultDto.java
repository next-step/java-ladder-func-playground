package dto;

public record LadderResultDto(Integer startIndex, Integer endIndex) {
    @Override
    public String toString() {
        return "%d -> %d".formatted(startIndex, endIndex);
    }
}
