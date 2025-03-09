package controller;

import model.*;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static model.Point.HAS_POINT;

public class LadderController {

    private static final int LADDER_SIZE = 4;
    private final ResultView resultView = new ResultView();
    private static final int CHUNK_SIZE = 3;

    public void startLadder() {
        PointGenerator pointGenerator = new PointGenerator(new Random());
        LadderGame ladderGame = new LadderGame(new Size(LADDER_SIZE), new Size(LADDER_SIZE), pointGenerator);
        List<Point> ladderPoints = ladderGame.getLadderPoints();
        List<Boolean> booleans = formatLadderPoints(ladderPoints);
        List<List<Boolean>> booleansChunks = processLadderLines(booleans);
        resultView.printLadder(booleansChunks);
    }

    private List<Boolean> formatLadderPoints(List<Point> ladderPoints) {
        List<Boolean> formattedLadder = new ArrayList<>();
        for (Point point : ladderPoints) {
            formattedLadder.add(point == HAS_POINT);
        }
        return formattedLadder;
    }

    private List<List<Boolean>> processLadderLines(List<Boolean> ladderPoints) {
        List<List<Boolean>> chunks = new ArrayList<>();
        for (int i = 0; i < ladderPoints.size(); i += CHUNK_SIZE) {
            chunks.add(getChunk(ladderPoints, i));
        }
        return chunks;
    }

    private List<Boolean> getChunk(List<Boolean> ladderPoints, int startIndex) {
        return ladderPoints.subList(startIndex, Math.min(startIndex + CHUNK_SIZE, ladderPoints.size()));
    }
}
