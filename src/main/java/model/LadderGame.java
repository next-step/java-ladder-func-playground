package model;

import constants.LadderConstants;
import dto.GameResultDto;
import dto.LadderResultDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constants.ErrorMessage.MADE_IMPOSSIBLE_GAME;


public class LadderGame {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        this.validateGame(players, prizes, ladder);
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    private void validateGame(Players players, Prizes prizes, Ladder ladder) {
        if (!Objects.equals(players.playerCount(), prizes.prizeCount())
                || !Objects.equals(prizes.prizeCount(), ladder.calculateWidth())
                || !Objects.equals(ladder.calculateWidth(), players.playerCount())) {
            throw new IllegalArgumentException(MADE_IMPOSSIBLE_GAME.getMessage());
        }
    }

    public GameResultDto checkSinglePlayer(String playerName) {
        int startIndex = players.calculateIndexOfPlayerName(playerName);
        LadderResultDto ladderResultDto = ladder.calculateSingleResultAsDto(startIndex);

        return this.ladderResultDtoToGameResultDto(ladderResultDto);
    }

    public List<GameResultDto> calculateEveryResult() {
        return IntStream.range(0, players.playerCount())
                .mapToObj(ladder::calculateSingleResultAsDto)
                .map(this::ladderResultDtoToGameResultDto)
                .toList();
    }

    private GameResultDto ladderResultDtoToGameResultDto(LadderResultDto ladderResultDto) {
        return new GameResultDto(players.getPlayerNameByIndex(ladderResultDto.startIndex()), prizes.getPrizeByIndex(ladderResultDto.endIndex()));
    }

    @Override
    public String toString() {
        return formatPlayerNames(players) + "\n"
                + formatLadder() + "\n"
                + formatPrizes(prizes);
    }

    private String formatPlayerNames(Players players) {
        return IntStream.range(0, players.playerCount())
                .mapToObj(i -> String.format("%" + LadderConstants.ENTRY_FIELD_WIDTH + "s", players.getPlayerNameByIndex(i)))
                .collect(Collectors.joining(LadderConstants.ENTRY_SEPARATOR));
    }

    private String formatPrizes(Prizes prizes) {
        return IntStream.range(0, prizes.prizeCount())
                .mapToObj(i -> String.format("%" + LadderConstants.ENTRY_FIELD_WIDTH + "s", prizes.getPrizeByIndex(i)))
                .collect(Collectors.joining(LadderConstants.ENTRY_SEPARATOR));
    }

    private String formatLadder() {
        return ladder.toString().lines()
                .map(line -> LadderConstants.LADDER_INDENT + line)
                .collect(Collectors.joining("\n"));
    }
}
