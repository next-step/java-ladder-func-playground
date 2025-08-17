package view;

import model.Line;

public class LineView {

    private static final String CONNECTION = "-----";
    private static final String EMPTY = "     ";

    public void print(Line line) {
        for (boolean connection : line.getConnections()) {
            System.out.print("|");
            System.out.print(connection ? CONNECTION : EMPTY);
        }
        System.out.println("|");
    }
}
