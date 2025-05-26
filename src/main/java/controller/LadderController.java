package controller;

import domain.LadderBoard;
import domain.LadderPath;
import domain.Participants;
import domain.PlayerResults;
import dto.LadderBuildResponse;
import dto.LadderResultResponse;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    private static final String ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = readParticipants();
        List<String> resultLabels = readResultLabels();
        int ladderHeight = readLadderHeight();

        LadderBuildResponse ladder = buildLadder(participants.getCount(), ladderHeight);
        printLadderBoard(participants.getNames(), resultLabels, ladder);

        PlayerResults playerResults = mapPlayerResults(participants, resultLabels, ladder);
        handleResultRequest(playerResults);
    }

    private Participants readParticipants() {
        outputView.printParticipantPrompt();
        List<String> names = inputView.readParticipantNames();
        return Participants.of(names);
    }

    private List<String> readResultLabels() {
        outputView.printResultPrompt();
        return inputView.readResultLabels();
    }

    private int readLadderHeight() {
        outputView.printHeightPrompt();
        return inputView.readLadderHeight();
    }

    private LadderBuildResponse buildLadder(int columnCount, int rowCount) {
        LadderBoard ladderBoard = LadderBoard.build(columnCount, rowCount);
        return LadderBuildResponse.from(ladderBoard);
    }

    private void printLadderBoard(List<String> participants, List<String> results, LadderBuildResponse ladder) {
        outputView.printLadderTitle();
        outputView.printParticipantNames(participants);
        outputView.printBridgeLines(ladder);
        outputView.printResultLabels(results);
    }

    private PlayerResults mapPlayerResults(Participants participants, List<String> results, LadderBuildResponse ladder) {
        LadderPath ladderPath = new LadderPath(ladder.lines(), ladder.columnCount());
        LadderResultResponse resultMapping = new LadderResultResponse(ladderPath.mapStartToEndIndex());
        return PlayerResults.from(participants, results, resultMapping.positionMap());
    }

    private void handleResultRequest(PlayerResults playerResults) {
        outputView.printResultSelectionPrompt();
        String name = inputView.readResultRequest();

        if (ALL_COMMAND.equals(name)) {
            outputView.printLadderTitle();
            outputView.printAllResults(playerResults.allResults());
            return;
        }

        if (playerResults.hasPlayer(name)) {
            outputView.printSingleResultWithTitle(playerResults.resultOf(name));
            return;
        }

        outputView.printNameNotFound();
    }
}
