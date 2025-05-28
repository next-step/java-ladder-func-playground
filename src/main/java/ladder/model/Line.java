package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> links;

    public Line(int width, LinkConnector linkConnector) {
        List<Boolean> links = linkConnector.generate(width);
        this.links = Collections.unmodifiableList(links);
    }

    public List<Boolean> getLinks() {
        return List.copyOf(links);
    }
}
