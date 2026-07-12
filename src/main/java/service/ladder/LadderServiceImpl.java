package service.ladder;

import domain.ladder.Ladder;
import domain.ladder.LadderInfo;
import domain.ladder.LadderLine;
import repository.ladder.LadderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderServiceImpl implements LadderService {

    private final LadderRepository ladderRepository;

    public LadderServiceImpl(final LadderRepository ladderRepository) {
        this.ladderRepository = ladderRepository;
    }

    @Override
    public void makeLadder(final int width, final int height) {
        ladderRepository.setLadder(new Ladder(makeLadderLines(height, width), new LadderInfo(width, height)));
    }

    private List<LadderLine> makeLadderLines(final int height, final int width) {
        return IntStream.range(0, height)
                .mapToObj(i -> makeLadderLine(width))
                .toList();
    }

    private LadderLine makeLadderLine(final int width) {
        List<Boolean> connections = makeConnections(width);
        return new LadderLine(connections);
    }

    private List<Boolean> makeConnections(final int width) {
        List<Boolean> connections = new ArrayList<Boolean>();
        Random random = new Random();

        while (connections.size() < width - 1) {
            addConnections(connections, random.nextBoolean());
        }

        return connections;
    }

    private void addConnections(final List<Boolean> connections, final boolean isConnected) {
        if (connections.isEmpty() || !isConnected || !connections.get(connections.size() - 1)) {
            connections.add(isConnected);
        }
    }

    @Override
    public Ladder getLadder() {
        return ladderRepository.getLadder();
    }
}
