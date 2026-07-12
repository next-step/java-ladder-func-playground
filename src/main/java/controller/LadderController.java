package controller;

import domain.ladder.Ladder;
import domain.ladder.LadderLine;
import domain.results.Results;
import domain.users.User;
import domain.users.Users;
import service.ladder.LadderService;
import service.results.ResultsService;
import service.users.UserService;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LadderService ladderService;
    private final UserService userService;
    private final ResultsService resultsService;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(final LadderService ladderService, final UserService userService, final ResultsService resultsService, final OutputView outputView, final InputView inputView) {
        this.ladderService = ladderService;
        this.userService = userService;
        this.resultsService = resultsService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        userService.makeUsers(inputView.inputUserNames());
        resultsService.saveResults(inputView.inputResults());
        ladderService.makeLadder(userService.getUsers().users().size(), inputView.inputHeight());

        userService.updatePosition(ladderService.getLadder(), userService.getUsers());

        printLadder(userService.getUsers(), ladderService.getLadder(), resultsService.getResults());
        printLadderResult(userService.getUsers(), resultsService.getResults());
    }

    private void printLadder(final Users users, final Ladder ladder, final Results results) {
        for (User user : users.users()) {
            outputView.printUser(user.getName());
        }
        outputView.printEmpty();
        for (LadderLine ladderLine : ladder.ladderLines()) {
            outputView.printLadderLine(ladderLine.connections());
        }
        for (String result : results.results()) {
            outputView.printResult(result);
        }
        outputView.printEmpty();
    }

    private void printLadderResult(final Users users, final Results results) {
        int printCount = 0;
        while (printCount < users.users().size()) {
            final String wantedUserName = inputView.inputWantedUserName();
            printResult(wantedUserName, users, results, wantedUserName.equals("all"));
        }
    }

    private void printResult(final String wantedUserName, final Users users, final Results results, final boolean isAll) {
        if (!isAll) {
            outputView.printExecutionResult();
            outputView.printUserResult(results.results()
                    .get(userService.findByName(wantedUserName).getPosition())
            );
            return;
        }

        outputView.printExecutionResult();
        for (User user : users.users()) {
            outputView.printAllUserResults(user.getName(), results.results()
                    .get(user.getPosition()));
        }
    }
}
