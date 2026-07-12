import controller.LadderController;
import repository.ladder.LadderRepository;
import repository.results.ResultsRepository;
import repository.users.UserRepository;
import service.ladder.LadderServiceImpl;
import service.results.ResultsServiceImpl;
import service.users.UserService;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(
                new LadderServiceImpl(new LadderRepository()),
                new UserService(new UserRepository()),
                new ResultsServiceImpl(new ResultsRepository()),
                new OutputView(),
                new InputView()
        );

        ladderController.start();
    }
}
