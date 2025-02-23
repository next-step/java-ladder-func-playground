package controller;

import domain.*;
import view.*;
import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private final GameResultView resultView = new GameResultView();
    private final GameInputView inputView = new GameInputView();
    private LadderGame ladderGame;

    public void createLadderGameByUser(){
        List<Player> playerList = new ArrayList<Player>();
        for(String player : inputView.inputLadderGamePlayersByConsole()){
            playerList.add(new Player(player));
        }

        List<Prize> prizeList = new ArrayList<Prize>();
        for(String prize : inputView.inputLadderGamePrizesByConsole()){
            prizeList.add(new Prize(prize));
        }

        ladderGame = new LadderGame(new Ladder(playerList.size(), inputView.inputLadderHeightByConsole()), playerList, prizeList);
    }

    public void runLadderPrinting(){
        resultView.printString("사다리 결과");
        for(Player player : ladderGame.getPlayers()){
            resultView.printPlayerName(player.getName());
        }
        resultView.printString("");
        for(Line line : ladderGame.getLadder().getLines()){
            resultView.printLadderLine(line.getPoints(), 5);
        }
        for(Prize prize : ladderGame.getPrizes()){
            resultView.printPlayerName(prize.getName());
        }
        resultView.printString("");
    }

    public boolean queryLadderGameResult(){
        String playerName = inputView.inputPlayerNameByConsole();
        resultView.printString("실행 결과");
        if(playerName.equals("all")){
            printAllResults();
            return false;
        }
        resultView.printString(ladderGame.queryPrizeOfPlayer(findPlayerByName(playerName)).getName());
        return true;
    }

    private Player findPlayerByName(String playerName){
        return ladderGame.getPlayers().stream().filter(player -> player.getName().equals(playerName)).findFirst().orElse(null);
    }

    private void printAllResults(){
        for(Player player : ladderGame.getPlayers()){
            resultView.printPairOfPlayerWithPrize(player.getName(), ladderGame.queryPrizeOfPlayer(player).getName());
        }
    }
}