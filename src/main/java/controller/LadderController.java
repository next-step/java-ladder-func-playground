package controller;

import domain.Ladder;
import domain.Line;
import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.OutputView;

public class LadderController {

    public final int width = InputView.getWidth();
    public final int height = InputView.getHeight();

    Random rd = new Random();

    public void run() {
        Ladder ladder = new Ladder();

        for (int i = 0; i < height; i++) {
            List<Boolean> points = addPointsBoolean();
            Line line = new Line(points);
            ladder.add(line);

        }
        OutputView.printLadder(ladder);
    }

    public List<Boolean> addPointsBoolean() {
        //가로 길이 만큼 t/f 랜덤값 투입 -> line 만들기

        List<Boolean> booleanList = new ArrayList<>();
        boolean beforeConnected = false;

        for (int i = 1; i < width; i++) {
            boolean current = getNextConnection(beforeConnected);
            booleanList.add(current);
            beforeConnected = current;
        }
        return booleanList;
    }

    private boolean getNextConnection(boolean beforeConnected) {
        if (beforeConnected) {
            return false;
        }
        return rd.nextBoolean();
    }
}
