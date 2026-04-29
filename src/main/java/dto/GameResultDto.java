package dto;

public record GameResultDto(String playerEntry, String prizeEntry) {
    @Override
    public String toString() {
        return "%s : %s".formatted(playerEntry, prizeEntry);
    }
}
