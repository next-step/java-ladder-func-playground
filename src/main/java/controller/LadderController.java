package controller;

import dto.response.GetLadderAllResultResponse;
import dto.response.GetLadderCanvasResponse;
import dto.response.GetLadderResultResponse;
import service.LadderService;
import util.Parser;
import view.LadderInputView;
import view.LadderOutputView;

import java.util.List;

import static constant.LadderConstant.RESERVED_WORD;

public class LadderController {

    public static final char DELIMITER = ',';

    private final LadderService ladderService;
    private final LadderInputView ladderInputView;
    private final LadderOutputView ladderOutputView;

    public LadderController(LadderService ladderService, LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderService = ladderService;
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public void play() {
        requestParticipantNames();
        requestLadderResults();
        requestLadderHeight();
        printLadderCanvas();
        requestResultViewerAndPrintViewerLadderResult();
    }

    private void requestParticipantNames() {
        String inputNames = ladderInputView.inputParticipantNames();
        List<String> names = Parser.parseStringDelimiter(inputNames, DELIMITER);
        ladderService.createParticipants(names);
    }

    private void requestLadderResults() {
        String inputResults = ladderInputView.inputLadderResults();
        List<String> results = Parser.parseStringDelimiter(inputResults, DELIMITER);
        ladderService.createLadderResults(results);
    }

    private void requestLadderHeight() {
        int inputHeight = ladderInputView.inputLadderHeight();
        ladderService.createLadder(inputHeight);
    }

    private void printLadderCanvas() {
        GetLadderCanvasResponse response = ladderService.getLadderCanvas();
        ladderOutputView.printLadderCanvas(response.names(), response.ladders(), response.results());
    }

    private void requestResultViewerAndPrintViewerLadderResult() {
        String inputViewerName = ladderInputView.inputResultViewer();
        if (validateRequestAllViewer(inputViewerName)) {
            printAllLadderResult();
            return;
        }
        printViewerLadderResult(inputViewerName);
    }

    private boolean validateRequestAllViewer(String viewerName) {
        return viewerName.equals(RESERVED_WORD);
    }

    private void printAllLadderResult() {
        GetLadderAllResultResponse response = ladderService.getAllLadderResult();
        ladderOutputView.printAllLadderResult(response.results());
    }

    private void printViewerLadderResult(String viewerName) {
        GetLadderResultResponse response = ladderService.getLadderResult(viewerName);
        ladderOutputView.printLadderResult(response.result());
    }
}
