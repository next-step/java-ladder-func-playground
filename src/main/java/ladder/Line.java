package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> points;

    public Line(Width width, LinkStrategy strategy) {
        this.points = new ArrayList<>();
        generateLinks(width, strategy);
    }

    private void generateLinks(Width width, LinkStrategy strategy) {
        boolean prevLinked = false;
        for (int col = 0; col < width.width() - 1; col++) {
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

    public boolean isLinkedAt(int col) {
        return points.get(col).isLinked();
    }

    public void linkAt(int col) {
        points.get(col).link();
    }

    public void unlinkAt(int col) {
        points.get(col).unlink();
    }

    public List<Link> getLinks() {
        return List.copyOf(points);
    }



}




