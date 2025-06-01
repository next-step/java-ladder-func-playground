import config.GameConfig;
import domain.LadderGame;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Reward;
import domain.Rewards;
import java.util.List;
import java.util.Objects;
import view.InputView;
import view.OutputView;

public class LadderGameApp {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Players players = getPlayers(inputView);
        Rewards rewards = getRewards(inputView);
        GameConfig gameConfig = getGameConfig(inputView, players.size());

        LadderGame ladderGame = LadderGame.of(gameConfig);
        LadderResult ladderResult = ladderGame.play(players,rewards);
        outputView.printLadderState(ladderGame.getLadder(), players, rewards);
        printTargetResult(inputView, outputView, ladderResult);
    }

    private static void printTargetResult(InputView inputView, OutputView outputView, LadderResult ladderResult) {
        String targetPlayerName = inputView.getTargetPlayerName();
        if (Objects.equals(targetPlayerName, "all")) {
            outputView.printLadderResult(ladderResult);
            return;
        }

        outputView.printTargetReward(targetPlayerName, ladderResult);
    }

    private static Players getPlayers(InputView inputView) {
        List<String> names = inputView.getPlayers();
        List<Player> playerList = names.stream()
                .map(Player::new)
                .toList();
        return new Players(playerList);
    }

    private static Rewards getRewards(InputView inputView) {
        List<String> rewards = inputView.getRewards();
        List<Reward> rewardList = rewards.stream()
                .map(Reward::new)
                .toList();
        return new Rewards(rewardList);
    }

    private static GameConfig getGameConfig(InputView inputView, int width) {
        final int height = inputView.getHeight();
        return new GameConfig(width, height);
    }
}
