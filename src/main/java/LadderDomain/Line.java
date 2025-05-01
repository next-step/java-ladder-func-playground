package LadderDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Connection> connections;

    public Line(int width, Random random) {
        connections = new ArrayList<>();
        int i = 0;
        while (i < width - 1) {
            boolean connectLadder = random.nextBoolean();
            connections.add(new Connection(connectLadder));
            if (connectLadder) {
                connections.add(new Connection(false));
                i += 2;
            } else {
                i += 1;
            }
        }
        while (connections.size() < width - 1) {
            connections.add(new Connection(false));
        }
    }

    public int move(int index) {
        if (index < connections.size() && connections.get(index).hasRight()) return index + 1;
        if (index > 0 && connections.get(index - 1).hasRight()) return index - 1;
        return index;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }
}
