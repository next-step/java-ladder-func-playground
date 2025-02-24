package domain;

import exception.InvalidPlayerNameException;
import exception.PlayerPrizeSizeMismatchException;

public class LadderGameData {

    private final Players players;
    private final Prizes prizes;

    public LadderGameData(Players players, Prizes prizes) {
        validateSizes(players, prizes);
        validateNoDuplicates(players);
        this.players = players;
        this.prizes = prizes;
    }

    private void validateSizes(Players players, Prizes prizes) {
        if (players.getNames().size() != prizes.getNames().size()) {
            throw new PlayerPrizeSizeMismatchException("참여자 수와 상품 수가 일치하지 않습니다.");
        }
    }

    private void validateNoDuplicates(Players players) {
        if (players.getNames().size() != players.getNames().stream().distinct().count()) {
            throw new InvalidPlayerNameException("중복된 이름이 존재합니다.");
        }
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
