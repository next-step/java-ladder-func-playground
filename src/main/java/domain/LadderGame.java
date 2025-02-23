package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final List<Player> players;
    private final List<Prize> prizes;

    public LadderGame(Ladder ladder, List<Player> players, List<Prize> prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public Prize queryPrizeOfPlayer(Player player) {
        int startPosition = players.indexOf(player); // 플레이어의 시작 위치 (인덱스)
        if (startPosition == -1) {
            throw new IllegalArgumentException("해당 플레이어는 게임에 참여하지 않았습니다.");
        }

        LadderDestinationFinder ladderladderDestinationFinder = new LadderDestinationFinder(ladder);
        int destination = ladderladderDestinationFinder.findDestinationOfLadder(startPosition); // 사다리 타기 결과

        if (destination < 0 || destination >= prizes.size()) {
            throw new IllegalStateException("사다리 게임 결과가 유효하지 않습니다. 상품 범위를 벗어났습니다.");
        }
        return prizes.get(destination); // 도착 위치에 있는 상품 반환
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

}
