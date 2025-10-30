package controller;

import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderResult;
import domain.LadderResultCalculator;
import generator.LadderGenerator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderController {
    private final LadderGenerator ladderGenerator;
    private final LadderBuilder ladderBuilder;
    private final OutputView outputView;
    private final InputView inputView;
    private final LadderResultCalculator ladderResultCalculator;

    public LadderController(LadderGenerator ladderGenerator, LadderBuilder ladderBuilder, OutputView outputView, InputView inputView, LadderResultCalculator ladderResultCalculator) {
        this.ladderGenerator = new LadderGenerator();
        this.ladderBuilder = new LadderBuilder();
        this.outputView = new OutputView();
        this.inputView = inputView;
        this.ladderResultCalculator = new LadderResultCalculator();
    }

    public void run() {
        List<String> players = getPlayers();
        List<String> prizes = getPrizes();
        int colCount = players.size();
        int rowCount = getRow();
        Ladder ladder = ladderGenerator.generateLadder(colCount, rowCount);
        List<String> ladderString = ladderBuilder.buildLadder(ladder);
        outputView.printLadder(ladderString);
        LadderResult calculatedResult = new LadderResult(ladderResultCalculator.calculateResults(ladder,players,prizes));
        checkPrizesForPlayers(calculatedResult.getMappedResult());
    }

    public List<String> getPlayers() {
        outputView.printPlayersInputMessage();
        String playersInput = inputView.getInputPlayers();
        return Arrays.asList(playersInput.split(","));
    }

    public List<String> getPrizes(){
        outputView.printPrizesInputMessage();
        String prizesInput = inputView.getInputPrizes();
        return Arrays.asList(prizesInput.split(","));
    }

    public void checkPrizesForPlayers(Map<String,String> calculatedResult){
        while(true){
            outputView.printAskPlayerMessage();
            String selectedPlayer = inputView.getInputSelectedPlayer();
            findPrizeForSelectedPlayer(selectedPlayer,calculatedResult);
        }
    }

    public void findPrizeForSelectedPlayer(String selectedPlayer, Map<String,String> calculatedResult){
        if(selectedPlayer=="all") outputView.printAllResultMessage(calculatedResult);
        else if(calculatedResult.containsKey(selectedPlayer)){
            outputView.printSingleResultMessage(calculatedResult.get(selectedPlayer));
        }
        else{
            outputView.printInvalidSelectedPlayerMessage();
        }


    }



    public int getRow() {
        outputView.printRowInput();
        return inputView.getInputRow();
    }
}
