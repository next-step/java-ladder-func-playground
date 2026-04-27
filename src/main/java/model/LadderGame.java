package model;

import constants.ErrorMessage;
import dto.GameResultDto;
import dto.LadderResultDto;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final int ENTRY_FIELD_WIDTH = 5;
    private static final String LADDER_INDENT = "    ";
    private static final String ENTRY_SEPARATOR = " ";

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

    public GameResultDto ladderResultDtoToGameResultDto(LadderResultDto ladderResultDto) {
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
                .mapToObj(i -> String.format("%" + ENTRY_FIELD_WIDTH + "s", entry.getEntryByIndex(i)))
                .collect(Collectors.joining(ENTRY_SEPARATOR));
    }

    private String formatLadder() {
        return ladder.toString().lines()
                .map(line -> LADDER_INDENT + line)
                .collect(Collectors.joining("\n"));
    }
}
