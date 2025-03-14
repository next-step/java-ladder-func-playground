package controller;

import dto.LadderResultDto;
import dto.LineDto;
import model.*;
import view.LadderInputView;
import view.LadderOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderController {

    private static final String PRINT_EVERY_RESULT = "all";

    private static final LadderController ladderController = new LadderController();

    private static final LadderOutputView ladderOutputView = LadderOutputView.getInstance();
    private static final LadderInputView ladderInputView = LadderInputView.getInstance();

    private LadderController() {
    }

    public static LadderController getInstance() {
        return ladderController;
    }

    public void run() {
        LadderUsers ladderUsers = getLadderUsers();
        String[] resultValues = ladderInputView.getResultValues();
        int height = ladderInputView.getHeight();

        Ladder ladder = new Ladder(ladderUsers.size(), height);
        LadderResultCalculator ladderResultCalculator = new LadderResultCalculator(ladderUsers, resultValues);
        printLadderShape(ladder, ladderUsers, resultValues);

        printLadderResultUntilPrintEveryResult(ladder, ladderResultCalculator, ladderUsers);
    }

    private LadderUsers getLadderUsers() {
        String[] names = ladderInputView.getNames();

        List<LadderUser> ladderUsers = Arrays.stream(names)
                .map(LadderUser::new)
                .toList();

        return new LadderUsers(ladderUsers);
    }

    private void printLadderShape(Ladder ladder, LadderUsers ladderUsers, String[] resultValues) {
        ladderOutputView.printLadderResultHeader();
        ladderOutputView.printNames(ladderUsers.getNames());

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            LineDto lineDto = LineDto.from(line);
            ladderOutputView.printLine(lineDto);
        }

        ladderOutputView.printResultValues(resultValues);
    }

    private void printLadderResultUntilPrintEveryResult(
            Ladder ladder,
            LadderResultCalculator ladderResultCalculator,
            LadderUsers ladderUsers
    ) {
        String targetName = ladderInputView.getTargetName();

        while (shouldPrintSingleResult(targetName)) {
            printSingleLadderResult(targetName, ladder, ladderResultCalculator);
            targetName = ladderInputView.getTargetName();
        }

        printEveryLadderResult(ladder, ladderResultCalculator, ladderUsers);
    }

    private boolean shouldPrintSingleResult(String targetName) {
        return !targetName.equals(PRINT_EVERY_RESULT);
    }

    private void printSingleLadderResult(
            String targetName,
            Ladder ladder,
            LadderResultCalculator ladderResultCalculator
    ) {
        String result = ladderResultCalculator.calculate(targetName, ladder);

        ladderOutputView.printLadderResult(result);
    }

    private void printEveryLadderResult(
            Ladder ladder,
            LadderResultCalculator ladderResultCalculator,
            LadderUsers ladderUsers
    ) {
        List<LadderResultDto> ladderResultDtos = new ArrayList<>();

        for (String name : ladderUsers.getNames()) {
            String result = ladderResultCalculator.calculate(name, ladder);
            ladderResultDtos.add(new LadderResultDto(name, result));
        }

        ladderOutputView.printLadderResults(ladderResultDtos);
    }

}
