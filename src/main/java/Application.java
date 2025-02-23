import controller.*;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.createLadderWithUserInput();
        ladderController.runLadderPrinting();
    }
}
