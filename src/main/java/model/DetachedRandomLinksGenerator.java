package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static model.LinkStatus.PRESENT;

public class DetachedRandomLinksGenerator implements LinksGenerator {

    private static final Random random = new Random();

    private final int linksSize;

    public DetachedRandomLinksGenerator(int linksSize) {
        this.linksSize = linksSize;
    }

    public List<Link> generate() {
        List<Link> links = getUndefinedLinks(linksSize);
        resolveUndefinedLinks(links);

        return Collections.unmodifiableList(links);
    }

    private List<Link> getUndefinedLinks(int linksSize) {
        List<Link> links = new ArrayList<>();
        for (int i = 0; i < linksSize; i++) {
            links.add(Link.getUndefinedLink());
        }

        return links;
    }

    private void resolveUndefinedLinks(List<Link> links) {
        int index = getRandomStartIndex(links);

        while (containsUndefined(links)) {
            boolean connectDecider = getConnectDecider();
            boolean connectable = isConnectable(index, links);

            links.set(index, Link.getDefinedLink(connectDecider, connectable));

            index = getNextIndex(index, links);
        }
    }

    private int getRandomStartIndex(List<Link> links) {
        return random.nextInt(links.size());
    }

    private boolean containsUndefined(List<Link> links) {
        return links.stream()
                .anyMatch(Link::isUndefined);
    }

    private boolean getConnectDecider() {
        return random.nextBoolean();
    }

    private boolean isConnectable(int index, List<Link> links) {
        return isLeftNotPresent(index, links) && isRightNotPresent(index, links);
    }

    private boolean isLeftNotPresent(int index, List<Link> links) {
        if (isFirstIndex(index)) {
            return true;
        }

        Link leftLink = links.get(index - 1);

        return leftLink.getLinkstatus() != PRESENT;
    }

    private boolean isRightNotPresent(int index, List<Link> links) {
        if (isLastIndex(index, links)) {
            return true;
        }

        Link rightLink = links.get(index + 1);

        return rightLink.getLinkstatus() != PRESENT;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private boolean isLastIndex(int index, List<Link> links) {
        return index == links.size() - 1;
    }

    private int getNextIndex(int index, List<Link> linkStatuses) {
        return (index + 1) % linkStatuses.size();
    }

}
