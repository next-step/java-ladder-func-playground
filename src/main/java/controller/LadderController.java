package controller;

import domain.Ladder;
import view.LadderView;

import java.util.Random;

public class LadderController {
    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;

    private final LadderView view;

    public LadderController() {
        this.view = new LadderView();
    }

    public void run() {
        Ladder ladder = new Ladder(HEIGHT, WIDTH, new Random());
        view.print(ladder);
    }
}
