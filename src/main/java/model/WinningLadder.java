package model;

import java.util.List;

public class WinningLadder {

    private final List<String> winnigResult;
    private int COUNT = 0;

    public WinningLadder(final List<String> winnigResult) {
        this.winnigResult = winnigResult;
    }

    public int rightPoint(boolean isResult) {
        if (isResult == true) {
            COUNT++;
        }
        return COUNT;
    }

    public int leftPoint(boolean isResult) {
        if (isResult == false) {
            COUNT--;
        }
        return COUNT;
    }
}
