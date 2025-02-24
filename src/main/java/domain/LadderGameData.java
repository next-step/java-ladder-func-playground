package domain;

import java.util.List;

public class LadderGameData {

    private final List<Player> players;
    private final List<Prize> prizes;

    public LadderGameData(List<Player> players, List<Prize> prizes) {
        validatePlayersAndPrizesSize(players, prizes);
        validateDuplication(players);
        this.players = players;
        this.prizes = prizes;
    }

    private void validatePlayersAndPrizesSize(List<Player> players, List<Prize> prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException("참여자 수와 상품 수가 일치하지 않습니다.");
        }
    }

    private void validateDuplication(List<Player> players) {
        if (players.size() != players.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
