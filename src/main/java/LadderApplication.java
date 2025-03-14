import controller.LadderController;

public class LadderApplication {

    public static void main(String[] args) {
        try {
            LadderController ladderController = LadderController.getInstance();
            ladderController.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
