import controller.LadderGameController;
import domain.FilteredRandomRungsBuilder;

public class LadderGameApplication {

    public static void main(String[] args) {
        final FilteredRandomRungsBuilder filteredRandomRungsBuilder = new FilteredRandomRungsBuilder();

        LadderGameController ladderGameController = new LadderGameController(filteredRandomRungsBuilder);
        ladderGameController.start();
    }

}
