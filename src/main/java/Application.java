import controller.*;

public class Application {
    public static void main(String[] args) {
        /*
        LadderController ladderController = new LadderController();
        ladderController.createLadderWithUserInput();
        ladderController.runLadderPrinting();
        ladderController.runLadderResultPrinting();
        */
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.createLadderGameByUser();
        ladderGameController.runLadderPrinting();
        while(ladderGameController.queryLadderGameResult()){

        }
    }
}
