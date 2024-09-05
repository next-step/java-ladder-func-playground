package service;

import domain.Ladder;

public class LadderService {
    public Ladder generateLadder(int height, int width){
        return new Ladder(height, width);
    }
}
