import controller.LadderGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LadderGameController ladderGameController = appConfig.setLadderController();

        ladderGameController.run();
    }
}
