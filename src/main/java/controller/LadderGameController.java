package controller;

import model.result.Prize;
import model.result.Prizes;
import model.participant.Player;
import model.participant.Players;
import model.ladder.Ladder;
import model.ladder.LadderGame;
import model.result.GameResult;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame(){
        try {
            Players players = createPlayers();
            Prizes prizes = createPrizes(players);
            Ladder ladder = createLadder(players.size());
            LadderGame ladderGame = new LadderGame(ladder);

            GameResult gameResult = calculateAllResults(ladderGame, players, prizes);

            outputView.printLadder(ladder, players, prizes);
            startResultQueryLoop(gameResult, players);

        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.printError(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            outputView.printError("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private Players createPlayers(){
        String namesLine = inputView.inputPeople();
        List<String> playerNames = Arrays.asList(namesLine.split(","));

        List<Player> playerList = new ArrayList<>();
        for(String playerName : playerNames){
            playerList.add(new Player(playerName.trim()));
        }
        return new Players(playerList);
    }

    private Prizes createPrizes(Players players){
        String prizeLine = inputView.inputResults();
        List<String> prizesType = Arrays.asList(prizeLine.split(","));

        List<Prize> prizeList = new ArrayList<>();
        for(String prize : prizesType){
            prizeList.add(new Prize(prize.trim()));
        }
        Prizes prizes = new Prizes(prizeList);
        validateInput(players, prizes);
        return prizes;
    }
    private void validateInput(Players players, Prizes prizes){
        if(players.size() != prizes.size()){
            throw new IllegalArgumentException("이름 수와 결과 수는 같아야 합니다.");
        }
    }

    private Ladder createLadder(int peopleCount){
        while (true) {
            try {
                int height = inputView.inputLadderHeight();
                return new Ladder(peopleCount, height);
            } catch (NumberFormatException e) {
                outputView.printError("숫자만 입력할 수 있습니다");
            }
        }
    }

    private GameResult calculateAllResults(LadderGame ladderGame, Players players, Prizes prizes) {
        GameResult gameResult = new GameResult();
        int peopleCount = players.size();

        for (int startColumn = 0; startColumn < peopleCount; startColumn++) {
            Player currentPlayer = players.getPlayerAt(startColumn);
            int resultColumn = ladderGame.trace(startColumn);
            Prize currentPrize = prizes.getPrizeAt(resultColumn);

            gameResult.addResult(currentPlayer, currentPrize);
        }
        return gameResult;
    }

    private void startResultQueryLoop(GameResult result, Players players) {
        String playerResult = inputView.inputPlayerName();
        while (!Objects.equals(playerResult, "all")) {
            outputView.printSingleResult(result, playerResult);
            playerResult = inputView.inputPlayerName();
        }
        outputView.printAllResults(result, players);
    }
}
