package model;

import constants.ErrorMessage;
import constants.LadderConstants;
import dto.GameResultDto;
import dto.LadderResultDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Player player;
    private final Prize prize;
    private final Ladder ladder;

    public LadderGame(Player player, Prize prize, Ladder ladder) {
        this.validateGame(player, prize, ladder);
        this.player = player;
        this.prize = prize;
        this.ladder = ladder;
    }

    private void validateGame(Player player, Prize prize, Ladder ladder) {
        if (!Objects.equals(player.entryCount(), prize.entryCount())
                || !Objects.equals(prize.entryCount(), ladder.calculateWidth())
                || !Objects.equals(ladder.calculateWidth(), player.entryCount())){
            throw new IllegalArgumentException(ErrorMessage.MADE_IMPOSSIBLE_GAME);
        }
    }

    public GameResultDto checkSingleEntry(String playerName) {
        int startIndex = player.calculateIndexOfEntry(playerName);
        LadderResultDto ladderResultDto = ladder.calculateSingleResultAsDto(startIndex);

        return this.ladderResultDtoToGameResultDto(ladderResultDto);
    }

    public List<GameResultDto> calculateEveryResult() {
        return IntStream.range(0, player.entryCount())
                .mapToObj(ladder::calculateSingleResultAsDto)
                .map(this::ladderResultDtoToGameResultDto)
                .toList();
    }

    private GameResultDto ladderResultDtoToGameResultDto(LadderResultDto ladderResultDto) {
        return new GameResultDto(player.getEntryByIndex(ladderResultDto.startIndex()),prize.getEntryByIndex(ladderResultDto.endIndex()));
    }

    @Override
    public String toString() {
        return formatEntries(player) + "\n"
                + formatLadder() + "\n"
                + formatEntries(prize);
    }

    private String formatEntries(LadderEntry entry) {
        return IntStream.range(0, entry.entryCount())
                .mapToObj(i -> String.format("%" + LadderConstants.ENTRY_FIELD_WIDTH + "s", entry.getEntryByIndex(i)))
                .collect(Collectors.joining(LadderConstants.ENTRY_SEPARATOR));
    }

    private String formatLadder() {
        return ladder.toString().lines()
                .map(line -> LadderConstants.LADDER_INDENT + line)
                .collect(Collectors.joining("\n"));
    }
}
