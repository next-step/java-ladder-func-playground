package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> points;

    public Line(int columnCount, LinkStrategy strategy) {
        this.points = new ArrayList<>();
        generateLinks(columnCount, strategy);
    }

    private void generateLinks(int columnCount, LinkStrategy strategy) {
        boolean prevLinked = false;
        for (int col = 0; col < columnCount - 1; col++) {
            Link link = createLink(strategy, prevLinked);
            prevLinked = link.isLinked();
            points.add(link);
        }
    }

    private Link createLink(LinkStrategy strategy, boolean prevLinked) {
        Link link = new Link();
        if (!prevLinked && strategy.canLink()) {
            link.link();
        }
        return link;
    }

    public List<Link> getLinks() {
        return List.copyOf(points);
    }



}




