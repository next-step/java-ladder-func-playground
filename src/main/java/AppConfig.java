import controller.LadderGameController;
import controller.Validator;
import domain.strategy.BooleanGenerator;
import domain.strategy.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class AppConfig {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    public LadderGameController setLadderController() {
        return new LadderGameController(inputView, outputView, validator, booleanGenerator);
    }
}
