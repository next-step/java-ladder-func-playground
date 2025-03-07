package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        if (players.size() != prizes.getPrizes().size()) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 일치해야 합니다.");
        }
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public GameResult play() {
        LadderResult ladderResult = ladder.play();
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            int finalIndex = ladderResult.getPositions().get(i).getValue();
            String playerName = players.getPlayers().get(i).getName().getValue();
            String prize = prizes.getPrizeAt(finalIndex).getValue();
            results.add(new Result(playerName, prize));
        }
        return new GameResult(results);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
